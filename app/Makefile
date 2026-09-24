setup: build-css
	./gradlew build installDist
build: build-css
	./gradlew build
test: build-css
	./gradlew test
run-dist:
	./gradlew installDist
	./build/install/app/bin/app
report:
	./gradlew test jacocoTestReport
checkstyle:
	./gradlew checkstyleMain checkstyleTest

.PHONY: run-chekstyleTest
run-chekstyleTest:
	./gradlew checkstyleTest

build-css:
	cd tailwind && npm ci
	cd tailwind && npm run build:css

.PHONY: build test run-dist report checkstyle
