---
name: project-steps
description: Describe what this skill does and when to use it. Include keywords that help agents identify relevant tasks.
---

<!-- Tip: Use /create-skill in chat to generate content with agent assistance -->

Define the functionality provided by this skill, including detailed instructions and examples.

This skill helps agents add TestNG test method scaffolding and apply the Page Object Model (POM) to an existing Java Selenium/Playwright test automation repository.

Typical usage:
- Add TestNG test methods scaffolding for new test flows (login, create patient, search patient, etc.).
- Propose test method signatures and simple assertions for review and approval.
- After approval, refactor tests to use the Page Object Model by creating page classes and moving selectors and actions into them.
- Run the test suite and report any failures to iterate on fixes.

Keywords: TestNG, TestNG scaffolding, POM, Page Object Model, Selenium, Playwright, Java, test automation, refactor

Phases:
1. Create TestNG test methods scaffolding
	- Add test method stubs to `src/test/java/.../test` that use TestNG annotations (`@Test`, `@BeforeMethod`, `@AfterMethod`).
	- Keep implementations minimal: open app, perform high-level actions, assert page title or element presence.
	- Submit the changes for review/approval before refactoring.

2. Apply Page Object Model (after approval)
	- Create page classes under `src/test/java/.../pages` or `src/main/java/.../pages` (consistent with project layout).
	- Move locators and interaction methods into page classes and update tests to use them.
	- Update any test setup/teardown in `AutomationWrapper.java` or `PlaywrightKeywords.java` as needed.

3. Run tests and iterate
	- Execute TestNG suites (e.g., `mvn test -Dtestng.xml` or via existing `testng.xml` files).
	- Fix failures and tidy code.

Example prompts for agents using this skill:
- "Scaffold TestNG tests for login and add-patient flows and open a PR with stubs."
- "Refactor `LoginTest` and `PatientTest` to use POM after the tests are approved."

Guidelines:
- Keep changes minimal and focused per commit/PR.
- Prefer adding tests first as lightweight stubs; wait for approval before large refactors.
- Follow existing project conventions for package layout and test utilities.
