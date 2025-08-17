# Minimal Nx Angular Gradle Monorepo

This is an Nx monorepo with both Angular and Gradle projects.

It is based on a [minimal Nx Angular monorepo](https://github.com/pvdhoef/minimal-nx-angular-monorepo)
in which a [minimal Gradle multi-module project](https://github.com/pvdhoef/minimal-gradle-multi-module-project)
has been integrated.

## Install the Nx Gradle plugin

Install the Gradle plugin package for Nx:
```sh
npm install --save-dev @nx/gradle
```

and refresh `node_modules`
```sh
rm -rf node_modules package-lock.json
npm install
```

Initialize Gradle support in Nx:
```sh
nx generate @nx/gradle:init
```

This will modify `nx.json`. It adda the pattern `"!{projectRoot}/src/test/**/*"` to `namedInputs/production`
and adds the following section to the `plugins` section:
```json
{
    "plugin": "@nx/gradle",
    "options": {
        "testTargetName": "test",
        "classesTargetName": "classes",
        "buildTargetName": "build"
    }
}
```

It also adds the plugin `id("dev.nx.gradle.project-graph") version("0.1.4")` to all Gradle projects but this has to
be edited a bit because the inserted code is not completely correct.
