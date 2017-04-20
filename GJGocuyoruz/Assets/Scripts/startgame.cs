using UnityEngine;
using System.Collections;

public class startgame : MonoBehaviour {


	// Use this for initialization
	void Start () {
		Application.LoadLevel ("SC1");
	}
	
	// Update is called once per frame
	void Update () {
	
	}

	void PlayGame(){
		Application.LoadLevel ("SC1");
	}
}
