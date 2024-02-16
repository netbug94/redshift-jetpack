#!/bin/bash

# Install button
sudo pacman -S redshift -y

# Update/upgrade
sudo pacman -Syu -y

# Keep the terminal open until a key is pressed
read -n 1 -s -r -p "Press any key to close the terminal..."