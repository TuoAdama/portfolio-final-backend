## Installation de cerificats en local


#### Générer un certificat auto-signé

```shell
openssl req -x509 -newkey rsa:4096 -keyout privkey.pem -out fullchain.pem -days 365 -nodes
```

#### Convertir en PKCS12

```shell
openssl pkcs12 -export -in certs/fullchain.pem -inkey certs/privkey.pem -out src/main/resources/keystore.p12 -name portfolio -passout pass:password
```

