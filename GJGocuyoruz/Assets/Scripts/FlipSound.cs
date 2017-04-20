using UnityEngine;
using System.Collections;

public class FlipSound : MonoBehaviour {

	AudioSource aus;
	bool delay;

	// Use this for initialization
	void Start () {
		aus = GetComponent<AudioSource> ();
		delay = true;
	}
	
	// Update is called once per frame
	void Update () {
		if (Input.GetKeyDown (KeyCode.Space)&& delay) {

			delay = false;
			aus.Play();
			Invoke ("delayTime", 0.4f);
		}
	
	}

	void delayTime(){
		delay = true;
	}
}
