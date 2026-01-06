# Create directories
$dirs = @(
    "src/main/java/com/example/framework/config",
    "src/main/java/com/example/framework/drivers",
    "src/main/java/com/example/framework/http",
    "src/main/java/com/example/framework/logging",
    "src/main/java/com/example/framework/reporting",
    "src/main/java/com/example/framework/utils",
    "src/test/java/com/example/tests/api",
    "src/test/java/com/example/tests/ui/pages",
    "src/test/java/com/example/tests/ui/flows",
    "src/test/resources/config",
    "src/test/resources/data",
    ".github/workflows"
)
foreach ($dir in $dirs) {
    New-Item -ItemType Directory -Force -Path $dir | Out-Null
}

# Create placeholder files
$files = @(
    "pom.xml",
    "src/main/java/com/example/framework/config/ConfigManager.java",
    "src/main/java/com/example/framework/config/Environment.java",
    "src/main/java/com/example/framework/drivers/DriverFactory.java",
    "src/main/java/com/example/framework/http/ApiClient.java",
    "src/main/java/com/example/framework/http/RequestSpecFactory.java",
    "src/main/java/com/example/framework/logging/Log.java",
    "src/main/java/com/example/framework/reporting/AllureTestListener.java",
    "src/main/java/com/example/framework/utils/DataGenerator.java",
    "src/main/java/com/example/framework/utils/RetryAnalyzer.java",
    "src/main/java/com/example/framework/utils/Waiter.java",
    "src/test/java/com/example/tests/BaseTest.java",
    "src/test/java/com/example/tests/TestGroups.java",
    "src/test/java/com/example/tests/ui/LoginUITest.java",
    "src/test/java/com/example/tests/ui/pages/LoginPage.java",
    "src/test/java/com/example/tests/ui/flows/AuthFlow.java",
    "src/test/java/com/example/tests/api/UserApiTest.java",
    "src/test/resources/config/base.yaml",
    "src/test/resources/config/qa.yaml",
    "src/test/resources/config/prod.yaml",
    "src/test/resources/data/users.json",
    "src/test/resources/log4j2.xml",
    ".github/workflows/ci.yml"
)
foreach ($file in $files) {
    if (!(Test-Path $file)) {
        New-Item -ItemType File -Force -Path $file | Out-Null
    }
}