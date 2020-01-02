organization in ThisBuild := "de.surfice"

version in ThisBuild := "0.0.1-SNAPSHOT"

scalaVersion in ThisBuild := "2.11.12"

val Version = new {
  val swog        = "0.1.0-SNAPSHOT"
  val smacrotools = "0.0.8"
  val utest       = "0.6.8-SNAPSHOT"
}


lazy val commonSettings = Seq(
  scalacOptions ++= Seq("-deprecation","-unchecked","-feature","-language:implicitConversions","-Xlint"),
  addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full),
  libraryDependencies ++= Seq(
    "de.surfice" %%% "swog-cxx" % Version.swog,
    "de.surfice" %%% "swog-cxxlib" % Version.swog,
    "com.lihaoyi" %%% "utest" % Version.utest % "test"
    ),
  resolvers += Opts.resolver.sonatypeSnapshots,
  testFrameworks += new TestFramework("utest.runner.Framework")
  )

lazy val nativeSettings = Seq(
  nativeLinkingOptions ++= Seq("-lglib-2.0","-lgtk-3.0","-lgobject-2.0","-ljson-glib-1.0"),
  nativeLinkStubs := true
)

lazy val openSceneGraph = project.in(file("."))
  .aggregate(osg,osgViewer)
  .enablePlugins(ScalaNativePlugin)
  .settings(commonSettings ++ dontPublish:_*)
  .settings(
    name := "scalanative-open-scene-graph"
    )

lazy val osg = project
  .enablePlugins(ScalaNativePlugin)
  .settings(commonSettings ++ publishingSettings:_*)
  .settings(
    name := "scalanative-osg-core"
  )

lazy val osgDB = project
  .dependsOn(osg)
  .enablePlugins(ScalaNativePlugin)
  .settings(commonSettings ++ publishingSettings:_*)
  .settings(
    name := "scalanative-osg-db"
  )

 
lazy val osgViewer = project
  .dependsOn(osg)
  .enablePlugins(ScalaNativePlugin)
  .settings(commonSettings ++ publishingSettings:_*)
  .settings(
    name := "scalanative-osg-viewer"
  )

lazy val osgUtil = project
  .dependsOn(osg)
  .enablePlugins(ScalaNativePlugin)
  .settings(commonSettings ++ publishingSettings:_*)
  .settings(
    name := "scalanative-osg-util"
  )


lazy val demo = project
  .dependsOn(osgDB,osgViewer,osgUtil)
  .enablePlugins(ScalaNativePlugin,NBHCxxPlugin,NBHAutoPlugin)
  .settings(commonSettings ++ dontPublish)
  .settings(
    nbhCxxCXXFlags += "-DGL_SILENCE_DEPRECATION"
  )

lazy val dontPublish = Seq(
  publish := {},
  publishLocal := {},
  com.typesafe.sbt.pgp.PgpKeys.publishSigned := {},
  com.typesafe.sbt.pgp.PgpKeys.publishLocalSigned := {},
  publishArtifact := false,
  publishTo := Some(Resolver.file("Unused transient repository",file("target/unusedrepo")))
)

lazy val publishingSettings = Seq(
  publishMavenStyle := true,
  publishTo := {
    val nexus = "https://oss.sonatype.org/"
    if (isSnapshot.value)
      Some("snapshots" at nexus + "content/repositories/snapshots")
    else
      Some("releases"  at nexus + "service/local/staging/deploy/maven2")
  },
  pomExtra := (
    <url>https://github.com/jokade/scalanative-osg</url>
    <licenses>
      <license>
        <name>MIT License</name>
        <url>http://www.opensource.org/licenses/mit-license.php</url>
      </license>
    </licenses>
    <scm>
      <url>git@github.com:jokade/scalanative-osg</url>
      <connection>scm:git:git@github.com:jokade/scalanative-osg.git</connection>
    </scm>
    <developers>
      <developer>
        <id>jokade</id>
        <name>Johannes Kastner</name>
        <email>jokade@karchedon.de</email>
      </developer>
    </developers>
  )
)
 
