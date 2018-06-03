les scripts presents dans ce repertoire sont utilises lors du build du projet pour produire les scripts shell linux et windows de lancement du traitement
vous devez les adapter et construire le projet pour observer les scripts generes dans les livrables obtenus (repertoire /bin)

===============================
1) script licenceHeaderTemplate 

il s'agit d'une portion de script documentaire
documenter ici le nom du traitement, sa syntaxe d'appel et les parametres a communiquer
les elements documentes figureront en en-tete des scripts shell linux et windows

===============================
2) script unixScriptTemplate

il s'agit du corps du traitement unix
les donnees variabilisees ont cette forme :
@LICENSE_HEADER@

@ENV_SETUP@

@REPO@

@CLASSPATH@

@EXTRA_JVM_ARGUMENTS@

@APP_NAME@

@MAINCLASS@

@APP_ARGUMENTS@

@UNIX_BACKGROUND@

===============================
3) script windowsScriptTemplate

il s'agit du corps du traitement windows
les donnees variabilisees ont cette forme :
#LICENSE_HEADER#
#ENV_SETUP#
#JAVA_BINARY#
#REPO#
#CLASSPATH#
#EXTRA_JVM_ARGUMENTS#
#APP_NAME#
#MAINCLASS#
#APP_ARGUMENTS#

