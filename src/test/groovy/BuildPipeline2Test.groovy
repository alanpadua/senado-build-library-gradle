import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import com.lesfurets.jenkins.unit.LibClassLoader

import com.lesfurets.jenkins.unit.BasePipelineTest
import static com.lesfurets.jenkins.unit.global.lib.LibraryConfiguration.library
import static com.lesfurets.jenkins.unit.global.lib.LocalSource.localSource

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BuildPipeline2Test extends BasePipelineTest {

//    String sharedLibs = new File( System.getProperty("user.dir")+ '//build//libs//senado-build-library-gradle.jar' )
//    String sharedLibs = new File( System.getProperty("user.dir")+ '//build//libs//' )
    String sharedLibs = new File( System.getProperty("user.dir") )

    @Override
    @BeforeAll
    void setUp() throws Exception {

        scriptRoots += 'vars'
//        dirPath += '/senado-build-library-gradle'
        helper.registerAllowedMethod('pipeline', [Closure.class], null)
//        helper.registerAllowedMethod('options', [Closure.class], null)
//        helper.registerAllowedMethod('timeout', [Map.class], null)
//        helper.registerAllowedMethod('timestamps', [], null)
//        helper.registerAllowedMethod('agent', [Closure.class], null)
//        helper.registerAllowedMethod('stages', [Closure.class], null)
//        helper.registerAllowedMethod('steps', [Closure.class], null)
//        helper.registerAllowedMethod('script', [Closure.class], null)
//        helper.registerAllowedMethod('readMavenPom', [Map.class], null)
//        binding.setVariable('none', {})
//        binding.setVariable('any', {})
//        String clonePath = '/tmp'
//
//        println('localSource(dirPath):' + localSource(sharedLibs))
//        println('sharedLibs:' + sharedLibs)
//
//        def library = library()
//                .name('senado-build-library-gradle')
//                .allowOverride(true)
//                .implicit(false)
//                .targetPath(sharedLibs)
//                .defaultVersion("master")
//                .retriever(localSource(sharedLibs))
//                .build()
//
//        helper.registerSharedLibrary(library)
        super.setUp()
    }

    @Test
    void test() {
        runScript("job/library/Jenkinsfile")
        printCallStack()
    }

}


