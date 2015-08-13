# Sarcasmbot

This software is a chat generation module that replies sarcastically to user input. Feel free to use the code, and report bugs at: adityaj@cse.iitb.ac.in, and anoopk@cse.iitb.ac.in. 

If you happen to use this software, do cite the following paper: 

Aditya Joshi, Anoop Kunchukuttan, Pushpak Bhattacharyya, Mark J Carman. _SarcasmBot: An open-source sarcasm-generation module for chatbots_, WISDOM at KDD 2015, Sydney, Australia, August 2015.

The license file has also been included. 

##Usage
The included code is a java project. The code can be used as follows:

1. Download sentiwordlist.
2. Set up an eclipse (or similar) project. Import code from SarcasmTalker.
3. Download stanford-postagger. Uncompress.
4. Include the pos-tagger jars in the eclipse project.
6. Get the location of tagger modelfile. For example, for me, it was: ~/jars/stanford-postagger-full-2014-01-04/models/english-left3words-distsim.tagger
7. Modelfile in (6) is argument 1. Sentiwordlist path in (2) is argument 2. Call Main.sarcasticChatter with these two arguments.

The sentiwordlist can be downloaded from: http://www.cs.uic.edu/~liub/FBS/opinion-lexicon-English.rar

##Sample Java Snippet

 sarcasticChatter sc = new sarcasticChatter(postagger, sentiwordlist);
 System.out.println(sc.chat("Do you love chocolates?"));
 
##Authors
Aditya Joshi (aditya.m.joshi@gmail.com)
Anoop Kunchukuttan (anoop.kunchukuttan@gmail.com)

##Version: 0.2

##Revision Log
10th August 2015: First version uploaded

##LICENSE

Copyright Aditya Joshi 2015 - present
 
Sarcasmbot is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

Sarcasmbot is distributed in the hope that it will be useful, 
but WITHOUT ANY WARRANTY; without even the implied warranty of 
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the 
GNU General Public License for more details. 

You should have received a copy of the GNU General Public License 
along with Sarcasmbot.  If not, see <http://www.gnu.org/licenses/>.
