import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;

class Project{
	String name;
	int duration, score, bestBefore;
	HashMap<String, Integer> roles;

	Project(String n, int d, int s, int bb) {
		name = n;
		score = s;
		bestBefore = bb;
		roles = new HashMap<String, Integer>();
	}

	void addRole(String s, int l) {
		roles.put(s, l);
	}
}

class Contributor{
	String name;
	HashMap<String, Integer> skills;

	Contributor(String n){
		name = n;
		skills = new HashMap<String, Integer>();
	}

	void addSkill(String s, int l) {
		skills.put(s, l);
	}
}


public class Solution {

	public static void main(String[] args) throws FileNotFoundException {
		Sc sc = new Sc();
		int nbOfContributors = sc.nextInt();
		int nbOfProjects = sc.nextInt();

		Contributor[] contributors = new Contributor[nbOfContributors];
		String name;
		int numberOfSkills;
		Contributor cntbtr;
		for (int i=0; i<nbOfContributors; i++) {
			name = sc.next();
			numberOfSkills = sc.nextInt();
			cntbtr = new Contributor(name);
			String skillName;
			int skillLevel;
			for (int s=0; s<numberOfSkills; s++) {
				skillName = sc.next();
				skillLevel = sc.nextInt();
				cntbtr.addSkill(skillName, skillLevel);
			}
			contributors[i] = cntbtr;
		}

		Project[] projects = new Project[nbOfProjects];
		Project pr;
		int d, s, bb, numberOfRoles;
		for (int i=0; i<nbOfProjects; i++) {
			name = sc.next();
			d = sc.nextInt();
			s = sc.nextInt();
			bb = sc.nextInt();
			numberOfRoles = sc.nextInt();
			pr = new Project(name, d, s, bb);
			String skillName;
			int skillLevel;
			for (int r=0; r<numberOfRoles; r++) {
				skillName = sc.next();
				skillLevel = sc.nextInt();
				pr.addRole(skillName, skillLevel);
			}
			projects[i] = pr;
		}
		/*
		for (Contributor cr : contributors) {
			System.out.println(cr.name);
			System.out.println(cr.skills);
		}
		System.out.println();
		for (Project p : projects) {
			System.out.println(p.name);
			System.out.printf("days to complete: %d; score awarded: %d; best before day: %d\n",
					p.duration, p.score, p.bestBefore);
			System.out.println(p.roles);
		}
		*/
	}

}

class Sc{
	BufferedReader br;
	StringTokenizer st;

	Sc() throws FileNotFoundException {
		br = new BufferedReader(new FileReader("InputFile.txt"));
	}

	String next() {
		while (st == null || !st.hasMoreElements()) {
			try {
				st = new StringTokenizer(br.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return st.nextToken();
	}

	int nextInt() {
		return Integer.parseInt(next());
	}

	long nextLong() {
		return Long.parseLong(next());
	}

	double nextDouble() {
		return Double.parseDouble(next());
	}

	String nextLine() {
		String str = "";
		try {
			str = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}
}