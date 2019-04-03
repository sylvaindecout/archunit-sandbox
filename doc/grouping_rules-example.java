@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(packages = "test.sdc.archunit")
public class ArchitectureTest {
    @ArchTest
    public static final ArchRules hexagonal_architecture = ArchRules.in(HexagonalArchitectures.class);
}
