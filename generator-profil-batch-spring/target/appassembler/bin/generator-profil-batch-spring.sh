#!/bin/ksh
# ===============================================================================
#   FICHIER : xxxxxxxxxxxxxxxxxxxxx
#
#   DESCRIPTION FONCTIONNELLE
#
#   Script de lancement du batch de xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
#
#   SYNTAXE D'APPEL
#
#    xxxxxxxxsxxxxxxxxxxxxxxxxxxxxxxxx.ksh xxxxx xxxx ...
#
#   		Les param�tres
#
#    		- xxxxxxxxxxxxxxxxxxxx : ......
#
#
#   CODE RETOUR
#
#     0 		OK
#     Autre  ERREUR
#
# 	Pour AIX :
# 	La variable BASEDIR doit etre d�finie en dehors du ksh
#     Elle precise le repertoire dans lequel l'applicatif a ete installe
# ===============================================================================

#===============================================================================
#	La variable BASEDIR doit etre definie en dehors du ksh
#   Elle precise le repertoire dans lequel l'applicatif a ete installe
#===============================================================================
#===============================================================================
#	Variable de travail
#===============================================================================
REPLOG=$BASEDIR/log
REPO=$BASEDIR/lib
#===============================================================================
#	Parametrages Messages du batch
#===============================================================================
#========================= Messages
Msg_Aide="???????????? pour le traitement de ????????????"
Msg_Syntaxe="Syntaxe: [-h | -H | -? | -v] "
Msg_NbParametres=?
#========================= Recuperation du nom du script
NomScript=`basename $0 .ksh`
#========================= Nom de la log par defaut
LogKsh=${REPLOG}/${NomScript}`date +%Y%m%d`.log
# Message de debut script
print "Debut a `date`" | tee $LogKsh 

#===============================================================================
#	Parametrages JAVA du batch
#===============================================================================
#======= CLASSPATH SPECIFIQUE AU BATCH =========================================
CLASSPATH="$BASEDIR"/conf:"$BASEDIR"/conf:"$REPO"/c3p0-0.9.5.2.jar:"$REPO"/mchange-commons-java-0.2.11.jar:"$REPO"/postgresql-9.3-1102-jdbc41.jar:"$REPO"/generator-profil-batch-core-1.7-SNAPSHOT.jar:"$REPO"/spring-ldap-core-2.0.2.RELEASE.jar:"$REPO"/spring-data-commons-1.6.1.RELEASE.jar:"$REPO"/jcl-over-slf4j-1.7.1.jar:"$REPO"/spring-ldap-core-tiger-2.0.2.RELEASE.jar:"$REPO"/joda-time-2.9.4.jar:"$REPO"/joda-convert-1.8.1.jar:"$REPO"/spring-core-3.2.14.RELEASE.jar:"$REPO"/commons-logging-1.2.jar:"$REPO"/spring-tx-3.2.14.RELEASE.jar:"$REPO"/spring-beans-3.2.14.RELEASE.jar:"$REPO"/spring-expression-3.2.14.RELEASE.jar:"$REPO"/toolbox-batch-4.0-Final.jar:"$REPO"/jetty-6.1.26.jar:"$REPO"/jetty-util-6.1.26.jar:"$REPO"/servlet-api-2.5-20081211.jar:"$REPO"/log4j-api-2.3.jar:"$REPO"/log4j-core-2.3.jar:"$REPO"/log4j-slf4j-impl-2.3.jar:"$REPO"/slf4j-api-1.7.18.jar:"$REPO"/spring-test-3.2.14.RELEASE.jar:"$REPO"/spring-context-3.2.14.RELEASE.jar:"$REPO"/spring-jms-3.2.14.RELEASE.jar:"$REPO"/spring-aop-3.2.14.RELEASE.jar:"$REPO"/aopalliance-1.0.jar:"$REPO"/spring-jdbc-3.2.14.RELEASE.jar:"$REPO"/spring-orm-3.2.14.RELEASE.jar:"$REPO"/spring-oxm-3.2.14.RELEASE.jar:"$REPO"/spring-instrument-3.2.14.RELEASE.jar:"$REPO"/spring-batch-core-3.0.4.RELEASE.jar:"$REPO"/com.ibm.jbatch-tck-spi-1.0.jar:"$REPO"/javax.batch-api-1.0.jar:"$REPO"/xstream-1.4.4.jar:"$REPO"/xmlpull-1.1.3.1.jar:"$REPO"/xpp3_min-1.1.4c.jar:"$REPO"/jettison-1.2.jar:"$REPO"/spring-batch-infrastructure-3.0.4.RELEASE.jar:"$REPO"/spring-retry-1.1.0.RELEASE.jar:"$REPO"/spring-batch-integration-3.0.4.RELEASE.jar:"$REPO"/spring-integration-core-4.0.1.RELEASE.jar:"$REPO"/spring-messaging-4.0.5.RELEASE.jar:"$REPO"/commons-dbcp2-2.1.1.jar:"$REPO"/commons-pool2-2.4.2.jar:"$REPO"/aspectjrt-1.8.9.jar:"$REPO"/aspectjweaver-1.8.9.jar:"$REPO"/toolbox-base-4.0-Final.jar:"$REPO"/generator-profil-batch-spring-1.7-SNAPSHOT.jar:
#===============================================================================
#	FIN Parametrages JAVA du batch
#===============================================================================

#===============================================================================
# Corps du script
#===============================================================================

#===============================================================================
# Procedure affichage d'aide 
#===============================================================================
AfficheAide ()
{
  print ${Msg_Aide}
  print ${Msg_Syntaxe} $NomScript.ksh 
}

#===============================================================================
# Verification du nombre de parametres
#===============================================================================
case $# in
# Debut -- A desactive si le traitement n'accepte pas aucun parametre 
0) 	print " Aucun parametre " | tee -a $LogKsh 
		;;
# Fin -- A desactiver si le traitement n'accepte pas aucun parametre 

1) case $1 in 
   	-h | -H | "-?") AfficheAide 
			exit $0;;

# Debut -- A desactiver si le traitement n'accepte pas 1 parametre 
		*) 	PARAM_1=$1
		print ${Msg_NbParametres}" parametres - ??????????? :"${PARAM_1} | tee -a $LogKsh 
		;;
# Fin -- A desactiver si le traitement n'accepte pas 1 parametre 
# Debut -- A desactiver si le traitement accepte 1 parametre 
		*) 	printf "Ce script prend ${Msg_NbParametres} ou ? parametre(s) : \n" | tee -a $LogKsh 
			printf "Attention, fin anormale le `date`\n" | tee -a $LogKsh 
			exit ${3};;
# Fin -- A desactiver si le traitement accepte 1 parametre 


   esac
   ;;

# Debut -- A desactiver si le traitement n'accepte pas 2 parametres
2) 	PARAM_1=$1
	PARAM_2=$2
		print ${Msg_NbParametres}" parametres : " | tee -a $LogKsh 
		print  " - ?????????? :"${PARAM_1} | tee -a $LogKsh 
		print  " - ?????????? :"${PARAM_2} | tee -a $LogKsh 
		;;
# Fin -- A desactiver si le traitement n'accepte pas 2 parametres 
		
*) printf "Ce script prend ${Msg_NbParametres} ou 0 ????? A corriger suivant le traitement ????? parametre(s): \n" | tee -a $LogKsh 
   printf "Attention, fin anormale le `date`\n" | tee -a $LogKsh 
   exit ${3};;

esac

#===============================================================================
# Corps du script
#===============================================================================

# Lancement du batch Java
java $JAVA_OPTS  \
  -classpath "$CLASSPATH" \
  -Dapp.name="generator-profil-batch-spring" \
  -Dapp.pid="$$" \
  -Dapp.repo="$REPO" \
  -Dapp.home="$BASEDIR" \
  -Dbasedir="$BASEDIR" \
  org.springframework.batch.core.launch.support.CommandLineJobRunner \
  classpath:/jobs/job.xml exampleJob "$@"  >> $LogKsh
  
CODE_RETOUR=$?
if [ ${CODE_RETOUR} -eq 0 ]
then
  print "\n Traitement OK " | tee -a $LogKsh
  print "\n Fin normale a `date`" | tee -a $LogKsh
else
if [ ${CODE_RETOUR} -eq 51 ]
then
  print "\n Traitement OK avec des signalements" | tee -a $LogKsh
  print "\n ==> Aller voir dans le suivi batch <==" | tee -a $LogKsh
  print "\n Fin normale a `date`" | tee -a $LogKsh
  # pour $U qui n'accepte que 0 ou differe de 0 (==> Incident?))
  CODE_RETOUR=0
else
  print "\n------------------------------------------------" | tee -a $LogKsh 
  print "\nErreur sur Traitement                 "           | tee -a $LogKsh 
  print "\n------------------------------------------------" | tee -a $LogKsh  

  print "\n------------------------------------------------" | tee -a $LogKsh  
  print "\nATTENTION - Fin anormale le $(date) "             | tee -a $LogKsh 
  print "\n------------------------------------------------" | tee -a $LogKsh  
fi
fi
exit ${CODE_RETOUR}
