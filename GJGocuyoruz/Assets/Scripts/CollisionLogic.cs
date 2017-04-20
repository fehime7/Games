using UnityEngine;
using System.Collections;

public class CollisionLogic : MonoBehaviour {

	Rect messageBox;
	Rect messageBoxRev;
	Texture texrev;
	Texture	 tex;
	public string name;
	public string time;
	bool trigger;
	SpriteRenderer sr;
	bool isUp{get{return this.GetComponent<FlipNoGrav>().isUp;} }
	// Use this for initialization
	void Start () {
		trigger = false;
		sr = GetComponent<SpriteRenderer> ();

		messageBox = new Rect (Screen.width/1.5f, Screen.height/10.5f, Screen.width/4f, Screen.height/4f);
		messageBoxRev = new Rect (Screen.width/1.5f, Screen.height/1.7f, Screen.width/4f, Screen.height/4f);
		tex = (Texture2D)Resources.Load (name +"duz"+time);
		texrev = (Texture2D)Resources.Load (name +"ters"+time);
	}


	void OnTriggerEnter2D(Collider2D col){
		trigger = true;
		//Debug.Log ("collision");
	}

	void OnTriggerExit2D(Collider2D col){
		trigger = false;
	}


	void Update(){

	}
	void OnGUI(){
		if (trigger && isUp) {
			//GUI.Label(new Rect(750,25,100,100),"HELLO MADAFAKAAA");
			GUI.DrawTexture (messageBox, tex); 

		} else if (trigger && !isUp) {
			GUI.DrawTexture(messageBoxRev,texrev);
		}

		if (trigger && Input.GetKeyDown (KeyCode.E)) {
			//pick up item
			Debug.Log("picked up");

			//GUI.DrawTexture(new Rect(10,50,50,50),(Texture2D)sr.sprite);
			
		}
	}



}