Pour créer la base de données, le dump se trouve dans le dossier src/main/resources/db
Un cron job est a ajouter en plus du dump. Toutes les heures, il va supprimer tous les reports de plus de 24h.

Dans SLQDev :
* Allez dans la base de données,
* Dans le menu "Scheduler" -> "New Job"
* Dans le champ Type of Job :
-Type : PL/SQL

```SQL DELETE FROM report
WHERE date_report < SYSDATE - 1;
COMMIT;
```

* Repeat interval : toutes les heures
``` FREQ=HOURLY;BYHOUR=1 ```

* Un fichier collecction.json est disponible dans le dossier src/main/resources/postman pour importer les requêtes dans Postman.