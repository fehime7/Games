using UnityEngine;
using System.Collections;

public class writing : MonoBehaviour {

	public string metin;
	Rect messageBox;
	Rect messageBoxRev;
	bool trigger;
	SpriteRenderer sr;
	bool isUp{get{return this.GetComponent<FlipNoGrav>().isUp;} }
	RectTransform rectangle;
	public GUIStyle ww;
	Texture2D tex;
	// Use this for initialization
	void Start () {
		messageBox = new Rect (Screen.width / 1.5f, Screen.height / 10.5f, Screen.width / 4f, Screen.height / 4f);
		messageBoxRev = new Rect(Screen.width/1.5f, Screen.height/1.7f, Screen.width/4f, Screen.height/4f);
		//rectangle = messageBoxRev;
		tex = (Texture2D)Resources.Load ("gjtextbg");
		ww.wordWrap = true;
		ww.normal.background = tex;
		//ww.fontSize = 18;
		ww.padding.left = 4;
		ww.padding.right = 4;
		ww.padding.top = 4;
		ww.padding.bottom = 4;
		ww.normal.textColor = Color.white;

	
	}

	void OnTriggerEnter2D(Collider2D col){
		trigger = true;
		//Debug.Log ("collision");
	}
	
	void OnTriggerExit2D(Collider2D col){
		trigger = false;
	}
	// Update is called once per frame
	void Update () {
	

	}

	void OnGUI(){
		if (trigger && isUp) {
			GUI.Box (messageBox, metin,ww);
		} else if (trigger && !isUp) {

			//ww.wordWrap = true;
			//rectangle.rotation = Quaternion.Euler(0,180,180);
			GUIUtility.RotateAroundPivot(180,new Vector2(Screen.width/1.262f, Screen.height/1.38f));
			GUI.Box	(messageBoxRev,metin,ww);
			//GUIUtility.RotateAroundPivot(90,new Vector2(Screen.width/1.5f, Screen.height/1.7f));
		}
	}
}

