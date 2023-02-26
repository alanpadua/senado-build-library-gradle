import com.lesfurets.jenkins.unit.BasePipelineTest
import com.lesfurets.jenkins.unit.PipelineTestHelper
import org.junit.Before
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

import static com.lesfurets.jenkins.unit.global.lib.GitSource.gitSource
import static com.lesfurets.jenkins.unit.global.lib.LibraryConfiguration.library
import static com.lesfurets.jenkins.unit.global.lib.LocalSource.localSource


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BuildPipelineTest extends BasePipelineTest {

    @Delegate PipelineTestHelper pipelineTestHelper
//
//    @Override
//    @BeforeAll
//    void setUp() throws Exception {
////        scriptRoots += 'vars'
//        super.setUp()
////        helper.registerAllowedMethod('pipeline', [Closure.class], null)
////        helper.registerAllowedMethod('options', [Closure.class], null)
////        helper.registerAllowedMethod('timeout', [Map.class], null)
////        helper.registerAllowedMethod('timestamps', [], null)
////        helper.registerAllowedMethod('agent', [Closure.class], null)
////        helper.registerAllowedMethod('stages', [Closure.class], null)
////        helper.registerAllowedMethod('steps', [Closure.class], null)
////        helper.registerAllowedMethod('script', [Closure.class], null)
////        helper.registerAllowedMethod('readMavenPom', [Map.class], null)
////        binding.setVariable('none', {})
////        binding.setVariable('any', {})
////        String clonePath = '/tmp'
////
////        def library = library()
////                .name('senado-build-library-gradle')
////                .retriever(gitSource('git@github.com:alanpadua/senado-build-library-gradle.git'))
////                .targetPath(clonePath)
////                .defaultVersion("main")
////                .allowOverride(true)
////                .implicit(false)
////                .build()
////
////        helper.registerSharedLibrary(library)
//    }
    @Override
    @BeforeAll
    void setUp() throws Exception {
        super.setUp();

        helper.registerAllowedMethod('assertEquals', [Map.class], { 'ok' });
        helper.registerAllowedMethod('assertEquals', [String, String], { "ok" });

        def library = library()
                .name('senado-build-library-gradle')
                .retriever(gitSource('git@github.com:alanpadua/senado-build-library-gradle.git'))
                .targetPath('./')
                .defaultVersion("main")
                .allowOverride(true)
                .implicit(false)
                .build()
        helper.registerSharedLibrary(library)
    }

    @Test
    void test() {
        def script = loadScript('src/test/groovy/Jenkinsfile')
        script.run()
//        runScript("job/library/Jenkinsfile")
        printCallStack()
    }
}
