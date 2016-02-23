package com.voa.test

import java.util.Scanner
import scala.collection.immutable.List
import scala.util.Random
import scala.collection.mutable.ListBuffer
import scala.collection.immutable.ListMap


object MainBoard {
  
  case class Snake(var st_pos:Int,var end_pos:Int) 
  case class Ladder(var st_pos:Int,var end_pos:Int)
  case class Player(var curnt_pos:Int,var name:String)extends Dice
  
  
  
  def main (args:Array[String]){
    import Player._
    var turn =ListBuffer(null)
    var players=ListBuffer[Player]()
    printf("--------------Welcome to  Snake and Ladder Board Game !-----------------------\n")
    printf("------------------------------------------------------------------------------\n")
    printf("\n\n")
    printf("\t Please read Game Instructions  \t\n")
    printf("\t  1.Instructions to start playing the game \n")
    printf(" \t *.The game is multiplayer game,To start the game each player throws the die\n")
    printf("\t *.each die throw will result in any integer between 1-6 both inclusive ...\n")
    printf("\t  *.the player with the greatest face value of the die after a throw starts first followed by others\n")
    printf("\t  *.if the similar face value appears for two or three players,they repeat\n ")
    printf("\t  *.the same until it is decided \n")
    printf("\t  2.How to Play -> Game Rules \t\n")
    print("\t #.Initially tokens of all players are placed on start position which is 1 st Square...\n")
    printf("\t#.If a die throw results in  a face value of 3 ,then token is moved to 3 positions after the previous position\n ")
    printf("\t#.Token Movement on Ladder is  up that is only from bottom_of_ladder(end_point)  to top_of_ladder(start_point) \n ")
    printf("\t#.Token Movement with a Snake bite is down that is only  from head_of_snake(end_point) to tail_of_snake(start_point) \n ")
    
    printf("\t 3. Winning Strategy of The Game \t")
    printf("\t\t @.The first to reach 100 th Square is winner of the game \n")
    printf("\t\t @.When the Player is at the position 95th Square  or more , on a die throw it does not result in any move if \n ")
    printf("\t\t @.final position tends to be greater than 100,simply next turn for the following player is followed....\n")
    printf("\t\t @.The Game finishes when any player reaches the 100 th Square ...")
    printf("\n")
    printf("do you want to play against computer ? :\n")
    printf("enter 'y' to play against computer or 'n' for multiplayer mode: ")
    
    var sc:Scanner=new Scanner(System.in)
    val entry_point=sc.next() 
   
if(entry_point.equalsIgnoreCase("y")|entry_point.equalsIgnoreCase("Y"))  

  {
      printf("you are now playing with computer \n")
      printf("please wait while  game is initialising.....\n")
       //add players list
      var p1_comp= Player(1,"computer")
      var p2=Player(1,"player1")
      var throw1=p1_comp.throwDice
      var throw2=p2.throwDice
      println(throw1)
      println(throw2)
       //decide the queue
      if(throw1>=throw2)
      { 
        players+=p1_comp
        players+=p2
       }
      else{ 
         
        players+=p2
        players+=p1_comp
       
          }
     
     
       playGame(players)
        
  }
    
else if(entry_point.equalsIgnoreCase("n")|entry_point.equalsIgnoreCase("N"))
    
    {
     printf("Please enter number of players.............\n")
    val Num_Of_Players=sc.nextInt();
    if(Num_Of_Players>=2){
    println(s"The number of players :$Num_Of_Players ,please wait while initialising......\n")
    var i:Int=0
    var dieThrowingQueueMap=scala.collection.mutable.HashMap.empty[String,Int]
    for ( i<-(1 to Num_Of_Players))
    {
      
      var p=Player(1,"player"+i.toString())
      players+=p
      dieThrowingQueueMap+=(p.name->p.throwDice)
      print(p)
      
    }
    // sort the map from low to high 
    
    
    val sortedQueueMap=ListMap(dieThrowingQueueMap.toSeq.sortWith(_._2>_._2):_*)
    val players_list=ListBuffer[Player]()
    sortedQueueMap.foreach(s=>players_list+=Player(1,s._1))
    players.foreach { player => printf(player.curnt_pos+"::::::"+player.name) }
    //prepare the user queue to throw die 
     playGame(players_list)
    }
    else
    {
      printf("Please select suitable number of players")
      System.exit(-1);
      
    }
    
    }
    else{
      
      printf(s"Invalid input please restart the game: $sc.next()")
      System.exit(-1)
    }
    
    def playGame(players:ListBuffer[Player])
    { 
      import Snake._
      import Ladder._
      var current_throw_turn:String=null
      val snake_pos=List((20,1),(25,5),(30,6),(50,10),(60,20),(70,30),(80,10),(90,40),(90,80),(95,5))
      val ladder_pos=List((5,15),(12,20),(25,32),(40,50),(50,70),(55,75),(70,90),(18,42),(7,35),(36,72))
      
    def game_end:Boolean=
     {  var status=false
        players.foreach (x=>if(x.curnt_pos==100){
          status=true
          printf(s"Congratulations!!!,$x.name ,you have won the game .......")
          }
        else status=false
        )
        status
     }
      
    while(!game_end){
      
      
      
    }  
   }
    
  }
  
}