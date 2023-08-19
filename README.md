# SUREFIRE-2191 - can not modularize a junit project

This project builds a junit 5 extension as its main artifact and also uses Junit 5 to test it.

When modularizing it with module-info.java, the tests no longer work, but report

```
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-surefire-plugin:3.1.2:test (default-test) on project surefire-junit-bug:
[ERROR]
[ERROR] Please refer to /Users/henning/scratch/surefire-junit-bug/target/surefire-reports for the individual test results.
[ERROR] Please refer to dump files (if any exist) [date].dump, [date]-jvmRun[N].dump and [date].dumpstream.
[ERROR] ExecutionException There was an error in the forked process
[ERROR] class org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder (in unnamed module @0x69a10787) cannot access class org.junit.platform.commons.util.Preconditions (in module org.junit.platform.commons) because module org.junit.platform.commons does not export org.junit.platform.commons.util to unnamed module @0x69a10787
[ERROR] org.apache.maven.surefire.booter.SurefireBooterForkException: ExecutionException There was an error in the forked process
[ERROR] class org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder (in unnamed module @0x69a10787) cannot access class org.junit.platform.commons.util.Preconditions (in module org.junit.platform.commons) because module org.junit.platform.commons does not export org.junit.platform.commons.util to unnamed module @0x69a10787
[ERROR] 	at org.apache.maven.plugin.surefire.booterclient.ForkStarter.awaitResultsDone(ForkStarter.java:456)
[ERROR] 	at org.apache.maven.plugin.surefire.booterclient.ForkStarter.runSuitesForkOnceMultiple(ForkStarter.java:358)
[ERROR] 	at org.apache.maven.plugin.surefire.booterclient.ForkStarter.run(ForkStarter.java:296)
[ERROR] 	at org.apache.maven.plugin.surefire.booterclient.ForkStarter.run(ForkStarter.java:250)
[ERROR] 	at org.apache.maven.plugin.surefire.AbstractSurefireMojo.executeProvider(AbstractSurefireMojo.java:1203)
[ERROR] 	at org.apache.maven.plugin.surefire.AbstractSurefireMojo.executeAfterPreconditionsChecked(AbstractSurefireMojo.java:1055)
[ERROR] 	at org.apache.maven.plugin.surefire.AbstractSurefireMojo.execute(AbstractSurefireMojo.java:871)
[ERROR] 	at org.apache.maven.plugin.DefaultBuildPluginManager.executeMojo(DefaultBuildPluginManager.java:126)
[ERROR] 	at org.apache.maven.lifecycle.internal.MojoExecutor.doExecute2(MojoExecutor.java:328)
[ERROR] 	at org.apache.maven.lifecycle.internal.MojoExecutor.doExecute(MojoExecutor.java:316)
[ERROR] 	at org.apache.maven.lifecycle.internal.MojoExecutor.execute(MojoExecutor.java:212)
[ERROR] 	at org.apache.maven.lifecycle.internal.MojoExecutor.execute(MojoExecutor.java:174)
[ERROR] 	at org.apache.maven.lifecycle.internal.MojoExecutor.access$000(MojoExecutor.java:75)
[ERROR] 	at org.apache.maven.lifecycle.internal.MojoExecutor$1.run(MojoExecutor.java:162)
[ERROR] 	at org.apache.maven.plugin.DefaultMojosExecutionStrategy.execute(DefaultMojosExecutionStrategy.java:39)
[ERROR] 	at org.apache.maven.lifecycle.internal.MojoExecutor.execute(MojoExecutor.java:159)
[ERROR] 	at org.apache.maven.lifecycle.internal.LifecycleModuleBuilder.buildProject(LifecycleModuleBuilder.java:105)
[ERROR] 	at org.apache.maven.lifecycle.internal.LifecycleModuleBuilder.buildProject(LifecycleModuleBuilder.java:73)
[ERROR] 	at org.apache.maven.lifecycle.internal.builder.singlethreaded.SingleThreadedBuilder.build(SingleThreadedBuilder.java:53)
[ERROR] 	at org.apache.maven.lifecycle.internal.LifecycleStarter.execute(LifecycleStarter.java:118)
[ERROR] 	at org.apache.maven.DefaultMaven.doExecute(DefaultMaven.java:261)
[ERROR] 	at org.apache.maven.DefaultMaven.doExecute(DefaultMaven.java:173)
[ERROR] 	at org.apache.maven.DefaultMaven.execute(DefaultMaven.java:101)
[ERROR] 	at org.apache.maven.cli.MavenCli.execute(MavenCli.java:906)
[ERROR] 	at org.apache.maven.cli.MavenCli.doMain(MavenCli.java:283)
[ERROR] 	at org.apache.maven.cli.MavenCli.main(MavenCli.java:206)
[ERROR] 	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
[ERROR] 	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77)
[ERROR] 	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
[ERROR] 	at java.base/java.lang.reflect.Method.invoke(Method.java:568)
[ERROR] 	at org.codehaus.plexus.classworlds.launcher.Launcher.launchEnhanced(Launcher.java:283)
[ERROR] 	at org.codehaus.plexus.classworlds.launcher.Launcher.launch(Launcher.java:226)
[ERROR] 	at org.codehaus.plexus.classworlds.launcher.Launcher.mainWithExitCode(Launcher.java:407)
[ERROR] 	at org.codehaus.plexus.classworlds.launcher.Launcher.main(Launcher.java:348)
[ERROR] Caused by: org.apache.maven.surefire.booter.SurefireBooterForkException: There was an error in the forked process
[ERROR] class org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder (in unnamed module @0x69a10787) cannot access class org.junit.platform.commons.util.Preconditions (in module org.junit.platform.commons) because module org.junit.platform.commons does not export org.junit.platform.commons.util to unnamed module @0x69a10787
[ERROR] 	at org.apache.maven.plugin.surefire.booterclient.ForkStarter.fork(ForkStarter.java:628)
[ERROR] 	at org.apache.maven.plugin.surefire.booterclient.ForkStarter.lambda$null$3(ForkStarter.java:350)
[ERROR] 	at java.base/java.util.concurrent.FutureTask.run(FutureTask.java:264)
[ERROR] 	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1136)
[ERROR] 	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:635)
[ERROR] 	at java.base/java.lang.Thread.run(Thread.java:833)
```
