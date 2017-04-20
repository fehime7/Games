using UnityEngine;
using System.Collections;

public class Flip : MonoBehaviour {
	
	ConstantForce2D cf;
	public bool isUp;
	bool delay = true;


	// Use this for initialization
	void Start () {
		cf = GetComponent<ConstantForce2D>();

	
	}
	
	// Update is called once per frame
	void Update () {
		if(Input.GetKeyDown(KeyCode.Space)){
			if(isUp&&delay){

				delay = false;
				transform.rotation = Quaternion.Euler(0,180,180);
				transform.position += Vector3.down * 1.8f * Time.maximumDeltaTime;
				cf.enabled = true;
				isUp = false;

				Invoke("delayer",0.4f);



			}
			else if(!isUp && delay){
				delay = false;
				transform.rotation = Quaternion.Euler (0,0,0);
				transform.position += Vector3.up *  1.8f * Time.maximumDeltaTime;
				cf.enabled = false;
				isUp = true;

				Invoke("delayer",0.4f);

			}
		}
	
	}

	void delayer(){
		delay = true;
	}
}
