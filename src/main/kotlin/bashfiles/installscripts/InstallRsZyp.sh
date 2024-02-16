#!/bin/bash

# Install button
sudo zypper install redshift -y

# Update/upgrade
sudo zypper refresh ; sudo zypper update -y

# Keep the terminal open until a key is pressed
read -n 1 -s -r -p "Press any key to close the terminal..."