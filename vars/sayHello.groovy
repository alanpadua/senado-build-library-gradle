#!/usr/bin/env groovy

def call(String name = 'human') {
    // Any valid steps can be called from this code, just like in other
    // Scripted Pipeline
    def stdout = sh script:'ls', returnStdout: true
    def utils = new Utils()
    //no funcionaría bajo JenkinsPipelineUnit --> utils.mish()

    def utilities = new Utilities(this)
    utilities.mish()

    println "Hello, $name. $stdout"
}
