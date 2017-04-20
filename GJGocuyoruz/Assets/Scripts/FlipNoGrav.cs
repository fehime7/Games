using UnityEngine;
using System.Collections;

public class FlipNoGrav : MonoBehaviour {

	public bool isUp;
	bool delay;
	public float xcoord;
	public float ycoord;
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
				transform.position = new Vector3(xcoord,-ycoord);
				isUp = false;
				Invoke ("delayer", 0.4f);
			
			
			} else if (!isUp && delay) {
				delay = false;
				transform.rotation = Quaternion.Euler (0, 0, 0);
				transform.position = new Vector3(xcoord,ycoord);
				isUp = true;
				Invoke ("delayer", 0.4f);
			
			}
		}
	}
	


	void delayer(){
		delay = true;
	}
}
