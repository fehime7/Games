using UnityEngine;
using System.Collections;

public class flipCanvas : MonoBehaviour {
	int revpos = 0;
	int delay = 1;

	// Use this for initialization
	void Start () {
	
	}
	
	// Update is called once per frame
	void Update () {
		
		if (Input.GetKeyDown (KeyCode.Space)) {
			if (delay == 1) {
				delay=0;
				if (revpos == 1) {
					revpos = 0;
					transform.rotation = Quaternion.Euler (0, 0, 0);
					transform.position += Vector3.up * 3.25f * Time.maximumDeltaTime;

					Invoke ("delaytime",0.4f);
				} else {
					revpos = 1;
					transform.rotation = Quaternion.Euler (0, 180, 180);
					transform.position += Vector3.down * 3.25f * Time.maximumDeltaTime;

					Invoke ("delaytime",0.4f);
				}
			}
		}
	}
	void delaytime () {
		delay = 1; 
	}

	}


