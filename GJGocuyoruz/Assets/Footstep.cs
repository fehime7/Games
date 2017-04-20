using UnityEngine;
using System.Collections;

public class Footstep : MonoBehaviour {

	AudioSource aus;
	bool playing;
	// Use this for initialization
	void Start () {
		aus = GetComponent<AudioSource> ();
	}
	
	// Update is called once per frame
	void Update () {
		if (Input.GetKey (KeyCode.LeftArrow) || Input.GetKey (KeyCode.RightArrow)) {
			aus.PlayDelayed(100);
			playing = aus.isPlaying;
		}
	
	}
}
