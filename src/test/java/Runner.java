import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(
        plugin = {
                "pretty",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        },
        tags = "@helpdesk",
        features = {"classpath:features/"},
        glue = {"ru.lanit.at.steps", "ru.lanit.at.hooks", "ru.lanit.at.corecommonstep"}
)
public class Runner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = false)

    public Object[][] scenarios() {
        return super.scenarios();
    }
}
