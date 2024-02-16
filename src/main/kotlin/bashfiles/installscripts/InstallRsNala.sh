#!/bin/bash

# Install button
sudo nala install redshift -y

# Update/upgrade
sudo nala update ; sudo nala upgrade -y

# Keep the terminal open until a key is pressed
read -n 1 -s -r -p "Press any key to close the terminal..."