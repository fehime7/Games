using UnityEngine;
using System.Collections;

public class FlipRain : MonoBehaviour {

	public bool isUp;
	bool delay;
	
	// Use this for initialization
	void Start () {
		delay = true;
		
		
	}
	
	// Update is called once per frame
	void Update () {
		if (Input.GetKeyDown (KeyCode.Space)) {
			if (isUp && delay) {
				delay = false;
				transform.rotation = Quaternion.Euler (0, 180, 180);
				transform.position = new Vector3(0.36f,-1.39f);
				isUp = false;
				Invoke ("delayer", 0.4f);
				
				
			} else if (!isUp && delay) {
				delay = false;
				transform.rotation = Quaternion.Euler (0, 0, 0);
				transform.position = new Vector3(0.36f,1.39f);
				isUp = true;
				Invoke ("delayer", 0.4f);
				
			}
		}
	}
	
	
	
	void delayer(){
		delay = true;
	}
}
