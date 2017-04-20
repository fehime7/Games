using UnityEngine;
using System.Collections;

public class endgame : MonoBehaviour {


	// Use this for initialization
	bool trigger;

	void Start () {
	
	}

	void OnTriggerEnter2D(Collider2D col){
		trigger = true;
		//Debug.Log ("collision");
	}
	// Update is called once per frame
	void Update () {
	
	}


	void endGame(){
		Application.LoadLevel ("mainMenu");
		trigger = false;
	}

	void OnGUI(){
		if (trigger) {
			GUI.Label(new Rect(Screen.width/2,Screen.height/10,1000,1000),"THE END");
			Invoke("endGame",5);
		}
	}
}
