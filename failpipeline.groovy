pipeline {
    agent any
    environment {
        FAILED_STAGE = ""
    }
    stages {
        stage('x64 Stage') {
            steps {
                echo "Running x64 Stage"
                //error("Intentional failure in x64 Stage") // Simuloitu virhe
            }
            post {
                failure {
                    script { FAILED_STAGE = 'x64 Stage' }
                }
            }
        }
        stage('a4m Stage') {
            steps {
                echo "Running a4m Stage"
                error("Intentional failure in a4m Stage") // Simuloitu virhe
                // Lisää toimintoja, jotka voivat epäonnistua
            }
            post {
                failure {
                    script { FAILED_STAGE = 'a4m Stage' }
                }
            }
        }
        stage('HW Test Stage') {
            steps {
                echo "Running HW Test Stage"
                // Lisää toimintoja, jotka voivat epäonnistua
            }
            post {
                failure {
                    script { FAILED_STAGE = 'HW Test Stage' }
                }
            }
        }
    }
    post {
        failure {
            echo "FAILURE: ${FAILED_STAGE} failed."
        }
        success {
            echo "SUCCESS: All stages passed."
        }
    }
}
