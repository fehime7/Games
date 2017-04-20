using UnityEngine;
using System.Collections;

public class Inventory : MonoBehaviour {

	bool showInv;
	Rect invRect;
	Texture invbg;
	int invCounter;
	// Use this for initialization
	void Start () {
		invCounter = 0;
		showInv = false;
		invRect = new Rect (10, 50, Screen.width/7f, Screen.height/4f);
		invbg = (Texture2D)Resources.Load ("inventory_01");
	}
	
	// Update is called once per frame
	void Update () {
		if (Input.GetKeyDown (KeyCode.I) && invCounter == 0) {
			showInv = true;
			invCounter = 1;
		} else if (Input.GetKeyDown (KeyCode.I) && invCounter == 1) {
			showInv = false;
			invCounter = 0;
		}
	
	}

	void OnGUI(){
		if (showInv){
			GUI.DrawTexture(invRect,invbg);

	}
}
}
