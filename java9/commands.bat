javac -d out \
--module-path="C:\Program Files\Java\javafx-sdk-11.0.2\lib" \
--add-modules=javafx.controls,javafx.fxml \
--module-source-path src \
(cmd /r dir /s /b *.java)

java --module-path="C:\Program Files\Java\javafx-sdk-11.0.2\lib;out" \
--add-modules=javafx.controls,javafx.fxml \
-m easytext.gui/javamodularity.easytext.gui.Main

Remove-Item jars -Force -Recurse -ErrorAction SilentlyContinue

mkdir jars

jar -c -f jars\easytext.analysis.api.jar -C out\easytext.analysis.api .
jar -c -f jars\easytext.analysis.coleman.jar -C out\easytext.analysis.coleman .
jar -c -f jars\easytext.analysis.kincaid.jar -C out\easytext.analysis.kincaid .
jar -c -f jars\easytext.cli.jar --main-class javamodularity.easytext.cli.Main -C out\easytext.cli .
jar -c -f jars\easytext.gui.jar --main-class javamodularity.easytext.gui.Main -C out\easytext.gui .

jlink --module-path="C:\Program Files\Java\jdk-11.0.4\jmods;C:\Program Files\Java\javafx-sdk-11.0.2\lib;jars;" \
--add-modules easytext.cli,easytext.analysis.coleman,easytext.analysis.kincaid \
--launcher easytext-app=easytext.cli/javamodularity.easytext.cli.Main --strip-debug --output images --compress=2

.\images\bin\easytext-app.bat The_Raven.txt
