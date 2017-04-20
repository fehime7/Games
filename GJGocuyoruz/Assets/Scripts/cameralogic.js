#pragma strict

function Start () {

}

	var target : Transform;
 	var distance : float;
 
 function Update(){
 
     transform.position.x = target.position.x-distance;
 
 }