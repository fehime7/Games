﻿using UnityEngine;
using System.Collections;

public class moveV2 : MonoBehaviour {

	SpriteRenderer sr;
	ConstantForce2D cf;
	float speed = 0.6f;
	float jumpspeed = 16.0f;
	public bool isUp{get{return this.GetComponent<Flip>().isUp;} }
	public bool delay = true;
	int leftright = 0;
	Animator animator;
	//Vector3 rotationVector = new Vector3 (180,0,0);

	// Use this for initialization
	void Start () {
	
		sr = GetComponent<SpriteRenderer> ();
		cf = GetComponent<ConstantForce2D> ();
		animator = GetComponent<Animator> ();
		//Time.timeScale = 0.01f;
	}
	
	// Update is called once per frame
	void Update () {
		if (Input.GetKey (KeyCode.LeftArrow)) {

			transform.position += Vector3.left * speed * Time.deltaTime;
			animator.SetBool("move", true);
			if (leftright == 0 && isUp) {
				transform.rotation = Quaternion.Euler (0, 180, 0);
				leftright = 1;
			}

			if (leftright == 0 && !isUp) {
				transform.rotation = Quaternion.Euler (0, 0, 180);
				leftright = 1;
			}
		}
		if (Input.GetKeyUp (KeyCode.LeftArrow)) {
			animator.SetBool("move", false);

		}

		if (Input.GetKey (KeyCode.RightArrow)) {
			transform.position += Vector3.right * speed * Time.deltaTime;
			animator.SetBool("move", true);

			if (leftright == 1 && isUp) {
				transform.rotation = Quaternion.Euler (0, 0, 0);
				leftright = 0;
			}
			if (leftright == 1 && !isUp) {
				transform.rotation = Quaternion.Euler (0, 180, 180);
				leftright = 0;
			}
		}
		if (Input.GetKeyUp (KeyCode.RightArrow)) {
			animator.SetBool("move", false);
			
		}
		if (Input.GetKeyDown (KeyCode.UpArrow)) {
			if (delay) {
				if (isUp) {
					delay = false;
					transform.position += Vector3.up * jumpspeed * Time.deltaTime;
					Invoke ("delaytime", 0.4f);
				}	
				if (!isUp) {
					delay = false;
					transform.position += Vector3.down * jumpspeed * Time.deltaTime;
					Invoke ("delaytime", 0.4f);
				}
			}

		}
		/*
		if (Input.GetKeyDown (KeyCode.Space)) {

				if (isUp) {
					isUp = false;
				}
				if (!isUp) {
					isUp = true;
				}
				
			}
		*/
	}
//		
	void delaytime () {
		delay = true; 
	}
}