#!/bin/sh

TABLES="PAT PMT MGT STT RRT TVCT CVCT EIT ETT"

for files in $TABLES; do
	flavorc -gj $files_section.fl
	flavorc -gx $files_section.fl
done

