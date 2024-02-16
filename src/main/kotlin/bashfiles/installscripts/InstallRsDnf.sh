#!/bin/bash

# Install button
sudo dnf install redshift -y

# Update/upgrade
sudo dnf upgrade -y

# Keep the terminal open until a key is pressed
read -n 1 -s -r -p "Press any key to close the terminal..."