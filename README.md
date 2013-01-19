geored-uy
=========


Postgis Initialization
----------------------
Run in terminal as postgres user:
For production
$ psql -d georeduyDBTest -f /usr/share/postgresql/contrib/postgis-2.0/postgis.sql
$ psql -d georeduyDB -f /usr/share/postgresql/contrib/postgis-2.0/spatial_ref_sys.sql
For testing
$ psql -d georeduyTestDB -f /usr/share/postgresql/contrib/postgis-2.0/postgis.sql
$ psql -d georeduyTestDB -f /usr/share/postgresql/contrib/postgis-2.0/spatial_ref_sys.sql
