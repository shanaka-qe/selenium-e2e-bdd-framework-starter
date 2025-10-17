// Jenkins Pipeline Configuration
// Automated testing pipeline for Selenium E2E BDD Framework

pipeline {
    agent any
    
    // Build parameters
    parameters {
        choice(
            name: 'BROWSER',
            choices: ['chrome', 'firefox', 'edge'],
            description: 'Select browser for test execution'
        )
        choice(
            name: 'ENVIRONMENT',
            choices: ['dev', 'staging', 'prod'],
            description: 'Select environment for testing'
        )
        choice(
            name: 'TEST_SUITE',
            choices: ['smoke', 'regression', 'api', 'all'],
            description: 'Select test suite to execute'
        )
        booleanParam(
            name: 'HEADLESS',
            defaultValue: true,
            description: 'Run tests in headless mode'
        )
    }
    
    // Environment variables
    environment {
        MAVEN_HOME = tool 'Maven-3.9'
        JAVA_HOME = tool 'JDK-11'
        PATH = "${MAVEN_HOME}/bin:${JAVA_HOME}/bin:${PATH}"
        CI_MODE = 'true'
    }
    
    // Build options
    options {
        buildDiscarder(logRotator(numToKeepStr: '10', artifactNumToKeepStr: '10'))
        timestamps()
        timeout(time: 2, unit: 'HOURS')
        disableConcurrentBuilds()
    }
    
    // Build triggers
    triggers {
        // Poll SCM every 15 minutes
        pollSCM('H/15 * * * *')
        // Nightly regression tests at 2 AM
        cron('0 2 * * *')
    }
    
    stages {
        // Stage 1: Checkout
        stage('Checkout') {
            steps {
                echo '📦 Checking out code...'
                checkout scm
                sh 'git log -1 --pretty=format:"%h - %an: %s"'
            }
        }
        
        // Stage 2: Build
        stage('Build') {
            steps {
                echo '🔨 Building project...'
                sh 'mvn clean compile -DskipTests'
            }
        }
        
        // Stage 3: Compile Tests
        stage('Compile Tests') {
            steps {
                echo '🔨 Compiling test sources...'
                sh 'mvn test-compile'
            }
        }
        
        // Stage 4: Run Tests
        stage('Run Tests') {
            steps {
                script {
                    echo "🧪 Running ${params.TEST_SUITE} tests..."
                    def mvnCommand = "mvn verify"
                    
                    // Add test suite profile
                    if (params.TEST_SUITE != 'all') {
                        mvnCommand += " -P ${params.TEST_SUITE}"
                    }
                    
                    // Add environment profile
                    mvnCommand += " -P ${params.ENVIRONMENT}"
                    
                    // Add browser configuration
                    mvnCommand += " -Dwebdriver.driver=${params.BROWSER}"
                    
                    // Add headless mode
                    if (params.HEADLESS) {
                        mvnCommand += " -DHEADLESS=true"
                    }
                    
                    // Add CI mode
                    mvnCommand += " -DCI_MODE=true"
                    
                    // Execute tests
                    sh mvnCommand
                }
            }
            post {
                always {
                    echo '📊 Archiving test results...'
                    // Archive test results
                    junit allowEmptyResults: true, testResults: '**/target/cucumber-reports.xml'
                    
                    // Archive Serenity reports
                    archiveArtifacts artifacts: '**/target/site/serenity/**', allowEmptyArchive: true
                    
                    // Archive logs
                    archiveArtifacts artifacts: '**/target/logs/*.log', allowEmptyArchive: true
                }
            }
        }
        
        // Stage 5: Generate Reports
        stage('Generate Reports') {
            steps {
                echo '📈 Generating Serenity reports...'
                sh 'mvn serenity:aggregate'
            }
        }
        
        // Stage 6: Publish Reports
        stage('Publish Reports') {
            steps {
                echo '📤 Publishing HTML reports...'
                publishHTML([
                    allowMissing: false,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: 'target/site/serenity',
                    reportFiles: 'index.html',
                    reportName: 'Serenity Test Report',
                    reportTitles: 'Serenity BDD Report'
                ])
            }
        }
        
        // Stage 7: Code Quality (Optional)
        stage('Code Quality') {
            when {
                branch 'main'
            }
            steps {
                echo '🔍 Running code quality checks...'
                // Add SonarQube or other quality checks here
                sh 'mvn checkstyle:check || true'
            }
        }
    }
    
    // Post-build actions
    post {
        always {
            echo '🧹 Cleaning workspace...'
            cleanWs deleteDirs: true, patterns: [[pattern: '**/target/*', type: 'INCLUDE']]
        }
        
        success {
            echo '✅ Build successful!'
            emailext (
                subject: "✅ Jenkins Build Successful: ${env.JOB_NAME} - ${env.BUILD_NUMBER}",
                body: """
                    <h2>Build Successful</h2>
                    <p><strong>Job:</strong> ${env.JOB_NAME}</p>
                    <p><strong>Build Number:</strong> ${env.BUILD_NUMBER}</p>
                    <p><strong>Browser:</strong> ${params.BROWSER}</p>
                    <p><strong>Environment:</strong> ${params.ENVIRONMENT}</p>
                    <p><strong>Test Suite:</strong> ${params.TEST_SUITE}</p>
                    <p><strong>Build URL:</strong> <a href="${env.BUILD_URL}">${env.BUILD_URL}</a></p>
                    <p><strong>Test Report:</strong> <a href="${env.BUILD_URL}Serenity_Test_Report/">View Report</a></p>
                """,
                to: '${DEFAULT_RECIPIENTS}',
                mimeType: 'text/html'
            )
        }
        
        failure {
            echo '❌ Build failed!'
            emailext (
                subject: "❌ Jenkins Build Failed: ${env.JOB_NAME} - ${env.BUILD_NUMBER}",
                body: """
                    <h2>Build Failed</h2>
                    <p><strong>Job:</strong> ${env.JOB_NAME}</p>
                    <p><strong>Build Number:</strong> ${env.BUILD_NUMBER}</p>
                    <p><strong>Browser:</strong> ${params.BROWSER}</p>
                    <p><strong>Environment:</strong> ${params.ENVIRONMENT}</p>
                    <p><strong>Test Suite:</strong> ${params.TEST_SUITE}</p>
                    <p><strong>Build URL:</strong> <a href="${env.BUILD_URL}">${env.BUILD_URL}</a></p>
                    <p><strong>Console Output:</strong> <a href="${env.BUILD_URL}console">View Console</a></p>
                    <p>Please check the console output for details.</p>
                """,
                to: '${DEFAULT_RECIPIENTS}',
                mimeType: 'text/html'
            )
        }
        
        unstable {
            echo '⚠️ Build unstable - some tests failed'
            emailext (
                subject: "⚠️ Jenkins Build Unstable: ${env.JOB_NAME} - ${env.BUILD_NUMBER}",
                body: """
                    <h2>Build Unstable</h2>
                    <p>Some tests failed but build completed.</p>
                    <p><strong>Job:</strong> ${env.JOB_NAME}</p>
                    <p><strong>Build Number:</strong> ${env.BUILD_NUMBER}</p>
                    <p><strong>Test Report:</strong> <a href="${env.BUILD_URL}Serenity_Test_Report/">View Report</a></p>
                """,
                to: '${DEFAULT_RECIPIENTS}',
                mimeType: 'text/html'
            )
        }
    }
}

