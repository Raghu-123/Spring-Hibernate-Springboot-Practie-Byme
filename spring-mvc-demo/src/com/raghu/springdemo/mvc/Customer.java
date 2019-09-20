package com.raghu.springdemo.mvc;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.raghu.springdemo.mvc.validation.CourseCode;

public class Customer {
	
	private String firstName;
	
	@NotNull(message="is required")
	@Size(min=1,message="is required")
	private String lastName;
	
	@NotNull(message="is required")
	@Min(value=0,message="must be greater than or equal to zero")
	@Max(value=10,message="must be less than or equal to 10")
	private Integer freePasses;
	
	@Pattern(regexp="^[a-zA-Z0-9]{5}",message="only 5 chars/digits")
	private String postalCode;
	
	@CourseCode(value="TOPS",message="must start with TOPS")
	private String courseCode;
	/*
	 * @Email(regexp="^[]") private String email;
	 */

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getFreePasses() {
		return freePasses;
	}

	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	/*
	 * public String getEmail() { return email; }
	 * 
	 * public void setEmail(String email) { this.email = email; }
	 */
	
	/*
	 * After having exposed CIA black operations Treadstone and BlackBriar, Jason
	 * Bourne is on the run again. In an attempt to capture Bourne, CIA has
	 * kidnapped his girlfriend Marie Kreutz. This morning CIA released an encrypted
	 * message disclosing Marie's location, which only Bourne can decipher. Bourne
	 * figures out that Marie is on the top of a building having a 'n'-step
	 * staircase. The key to get past the door is a number 'x'- the number of ways
	 * to climb the 'n' steps in a non-decreasing order. Suppose, there are 4 steps
	 * - so 1,1,2 is a valid sequence of steps while 2,1,1 or 1,2,1 is not. So, 'x'
	 * is the number of such valid sequences.
	 * 
	 * Bourne is having a headache and asks you for help. Help Jason to find Marie.
	 * As 'x' will be large, you will tell Jason x % 10^9 + 7.
	 * 
	 * Input Format
	 * 
	 * An integer T followed by T lines each containing an integer N.
	 * 
	 * Output Format
	 * 
	 * An integer corresponding to each test case on a seprate line.
	 * 
	 * Constraints
	 * 
	 * 1<=T<=1000 1<=N<=1000
	 * 
	 * Sample Input
	 * 
	 * 5 1 2 3 4 5 Sample Output
	 * 
	 * 1 2 3 5 7 Explanation
	 * 
	 * For N = 1, there is only valid sequence [1] For N = 2, there are 2 valid
	 * sequences [1,1] and [2] For N = 3, there are 3 valid sequences [1,1,1], [1,2]
	 * and [3] for N = 4, there are 5 valid sequences [1,1,1,1], [1,1,2], [2,2],
	 * [1,3] and [4] for N = 5, there are 7 valid sequences [1,1,1,1,1], [1,1,1,2],
	 * [1,2,2], [1,1,3], [1,4], [2,3] and [5]
	 * 
	 * Submissions: 0 Max Score: 40 Difficulty: Hard Rate This Challenge:
	 * 
	 * 
	 * More
	 * 
	 */
}
