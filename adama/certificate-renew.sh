#!/bin/bash

source .env.local

openssl pkcs12 -export \
  -in $CERTIFICATE_FILE \
  -inkey $CERTIFICATE_PRIVATE_KEY_FILE \
  -out $APP_ROOT/src/main/resources/keystore.p12 \
  -name portfolio \
  -CAfile $CERTIFICATE_CHAIN_FILE \
  -caname root \
  -passout pass:$KEYSTORE_PASS