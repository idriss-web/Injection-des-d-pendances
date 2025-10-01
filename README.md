Le programme présenté utilise l'injection dynamique des dépendances à travers la réflexion en Java. Dans ce cas, les classes DaoImpl et MetierImpl sont chargées dynamiquement en fonction des informations contenues dans un fichier de configuration (config.txt).

Le fichier config.txt contient les noms de classes des implémentations de IDao et IMetier. Le programme utilise Class.forName() pour charger les classes spécifiées dans le fichier de configuration, puis crée des instances de ces classes avec newInstance().

La classe MetierImpl reçoit une instance de IDao via son constructeur et utilise cette instance pour effectuer des calculs. Par exemple, elle appelle la méthode getData() du DAO pour obtenir des données. Le résultat de la méthode calcul() est affiché en fonction de l'implémentation du DAO choisi, qu'il s'agisse d'une base de données ou d'un service web.

Cette approche rend l'application plus flexible et extensible, car l'implémentation des DAO peut être modifiée sans avoir à toucher au code métier. Cela illustre bien l'injection dynamique des dépendances en Java.
