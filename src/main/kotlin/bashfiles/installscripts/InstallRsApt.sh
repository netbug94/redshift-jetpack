#!/bin/bash

# Install button
sudo apt install redshift -y

# Update/upgrade
sudo apt update ; sudo apt upgrade -y

echo "By olracnai > https://github.com/olracnai" ; echo "Support redshift > http://jonls.dk/redshift/"

# Keep the terminal open until a key is pressed
read -n 1 -s -r -p "Press any key to close the terminal..."