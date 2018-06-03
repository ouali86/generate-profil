CREATE TABLE IF NOT EXISTS tpcittrace
(
  idtrace BIGINT,
  commentaire CHARACTER VARYING(255),
  datecreation TIMESTAMP,
  decision CHARACTER VARYING(255),
  domaine CHARACTER VARYING(255),
  sousdomaine CHARACTER VARYING(255),
  evenement CHARACTER VARYING(255),
  flux CHARACTER VARYING(255),
  idutilisateur CHARACTER VARYING(255),
  media CHARACTER VARYING(255),
  PRIMARY KEY (idtrace)
);