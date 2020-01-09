/* Name: Sneh
 * Filename:
 * Purpose:
 * */
package ChampSelect;

import java.util.TimerTask;

public class CheckBox extends TimerTask {

	Main cs = new Main(); 
	
	/* Purpose:
	 * Parameters:
	 * Return:
	 * */
	public void run() {
		
		if (cs.p1 == true) {
			if (cs.xCoord == 92) {
				int ar[][] = { { 0, 0, 73, 115 }, { 73, 0, 77, 115 }, { 150, 0, 81, 115 }, { 231, 0, 83, 115 },
						{ 317, 0, 85, 115 }, { 402, 0, 83, 115 }, { 485, 0, 81, 115 }, { 567, 0, 75, 115 } };
				cs.speed = 100;
				// cs.refresh = 9;
				cs.charPosX = 150;
				cs.charPosY = 200;
				cs.init("AndroidRest", ar);

			} else if (cs.xCoord == 175) {
				int ar[][] = { { 0, 0, 136, 117 }, { 138, 0, 136, 117 }, { 276, 0, 136, 117 }, { 414, 0, 136, 117 },
						{ 552, 0, 136, 117 }, { 690, 0, 136, 117 }, { 828, 0, 136, 117 }, { 966, 0, 136, 117 },
						{ 1104, 0, 136, 117 }, { 1242, 0, 136, 117 } };
				cs.speed = 100;
				// cs.refresh = 1000;
				cs.charPosX = 130;
				cs.charPosY = 200;
				cs.init("FriezaRest", ar);

			} else if (cs.xCoord == 258) {
				int ar[][] = { { 0, 0, 72, 104 }, { 74, 0, 72, 104 }, { 148, 0, 72, 104 }, { 222, 0, 72, 104 },
						{ 296, 0, 72, 104 }, { 370, 0, 72, 104 } };
				cs.speed = 110;
				// cs.refresh = 660;
				cs.charPosX = 170;
				cs.charPosY = 220;
				cs.init("GohanRest", ar);

			} else if (cs.xCoord == 341) {
				int ar[][] = { { 0, 0, 113, 111 }, { 115, 0, 113, 111 }, { 230, 0, 113, 111 }, { 345, 0, 113, 111 },
						{ 460, 0, 113, 111 }, { 575, 0, 113, 111 } };
				cs.speed = 110;
				// cs.refresh = 660;
				cs.charPosX = 170;
				cs.charPosY = 210;
				cs.init("GokuRest", ar);

			} else if (cs.xCoord == 424) {
				int ar[][] = { { 0, 0, 113, 186 }, { 115, 0, 113, 186 }, { 230, 0, 113, 186 }, { 345, 0, 113, 186 },
						{ 460, 0, 113, 186 }, { 575, 0, 113, 186 } };
				cs.speed = 110;
				// cs.refresh = 660;
				cs.charPosX = 170;
				cs.charPosY = 150;
				cs.init("CellRest", ar);

			} else if (cs.xCoord == 507) {
				int ar[][] = { { 0, 0, 130, 136 }, { 132, 0, 130, 136 }, { 264, 0, 130, 136 }, { 396, 0, 130, 136 },
						{ 528, 0, 130, 136 }, { 660, 0, 130, 136 } };
				cs.speed = 140;
				// cs.refresh = 680;
				cs.charPosX = 170;
				cs.charPosY = 185;
				cs.init("PicolloRest", ar);
			} else if (cs.xCoord == 590) {
				int ar[][] = { { 0, 0, 87, 112 }, { 89, 0, 87, 112 }, { 178, 0, 87, 112 }, { 267, 0, 87, 112 },
						{ 356, 0, 87, 112 }, { 445, 0, 87, 112 }, };
				cs.speed = 140;
				// cs.refresh = 680;
				cs.charPosX = 170;
				cs.charPosY = 210;
				cs.init("VegetaRest", ar);
			}

		} else if (cs.p1 == false) {
			if (cs.x == 341) {
				int ar[][] = { { 0, 0, 113, 111 }, { 115, 0, 113, 111 }, { 230, 0, 113, 111 }, { 345, 0, 113, 111 },
						{ 460, 0, 113, 111 }, { 575, 0, 113, 111 } };
				cs.speed = 110;
				// cs.refresh = 660;
				cs.charPosX = 170;
				cs.charPosY = 210;
				cs.init("GokuRest", ar);

			} else if (cs.x == 590) {
				int ar[][] = { { 0, 0, 87, 112 }, { 89, 0, 87, 112 }, { 178, 0, 87, 112 }, { 267, 0, 87, 112 },
						{ 356, 0, 87, 112 }, { 445, 0, 87, 112 }, };
				cs.speed = 140;
				// cs.refresh = 680;
				cs.charPosX = 170;
				cs.charPosY = 210;
				cs.init("VegetaRest", ar);
			}

			if (cs.xCoord == 92) {
				int ar[][] = { { 0, 0, 73, 115 }, { 73, 0, 77, 115 }, { 150, 0, 81, 115 }, { 231, 0, 83, 115 },
						{ 317, 0, 85, 115 }, { 402, 0, 83, 115 }, { 485, 0, 81, 115 }, { 567, 0, 75, 115 } };
				cs.speed = 100;
				// cs.refresh = 9;
				cs.char2PosX = 470;
				cs.char2PosY = 302;
				cs.init2("AndroidRest2", ar);
				
			} else if (cs.xCoord == 175) {
				int ar[][] = { { 0, 0, 136, 117 }, { 138, 0, 136, 117 }, { 276, 0, 136, 117 }, { 414, 0, 136, 117 },
						{ 552, 0, 136, 117 }, { 690, 0, 136, 117 }, { 828, 0, 136, 117 }, { 966, 0, 136, 117 },
						{ 1104, 0, 136, 117 }, { 1242, 0, 136, 117 } };
				cs.speed = 100;
				// cs.refresh = 1000;
				cs.char2PosX = 460;
				cs.char2PosY = 300;
				cs.init2("FriezaRest2", ar);

			} else if (cs.xCoord == 258) {
				int ar[][] = { { 0, 0, 72, 104 }, { 74, 0, 72, 104 }, { 148, 0, 72, 104 }, { 222, 0, 72, 104 },
						{ 296, 0, 72, 104 }, { 370, 0, 72, 104 } };
				cs.speed = 110;
				// cs.refresh = 660;
				cs.char2PosX = 480;
				cs.char2PosY = 310;
				cs.init2("GohanRest2", ar);

			} else if (cs.xCoord == 341) {
				int ar[][] = { { 0, 0, 113, 111 }, { 115, 0, 113, 111 }, { 230, 0, 113, 111 }, { 345, 0, 113, 111 },
						{ 460, 0, 113, 111 }, { 575, 0, 113, 111 } };
				cs.speed = 110;
				// cs.refresh = 660;
				cs.char2PosX = 470;
				cs.char2PosY = 310;
				cs.init2("GokuRest2", ar);

			} else if (cs.xCoord == 424) {
				int ar[][] = { { 0, 0, 113, 186 }, { 115, 0, 113, 186 }, { 230, 0, 113, 186 }, { 345, 0, 113, 186 },
						{ 460, 0, 113, 186 }, { 575, 0, 113, 186 } };
				cs.speed = 110;
				// cs.refresh = 660;
				cs.char2PosX = 470;
				cs.char2PosY = 235;
				cs.init2("CellRest2", ar);

			} else if (cs.xCoord == 507) {
				int ar[][] = { { 0, 0, 130, 136 }, { 132, 0, 130, 136 }, { 264, 0, 130, 136 }, { 396, 0, 130, 136 },
						{ 528, 0, 130, 136 }, { 660, 0, 130, 136 } };
				cs.speed = 140;
				// cs.refresh = 680;
				cs.char2PosX = 460;
				cs.char2PosY = 290;
				cs.init2("PicolloRest2", ar);
				
			} else if (cs.xCoord == 590) {
				int ar[][] = { { 0, 0, 87, 112 }, { 89, 0, 87, 112 }, { 178, 0, 87, 112 }, { 267, 0, 87, 112 },
						{ 356, 0, 87, 112 }, { 445, 0, 87, 112 }, };
				cs.speed = 140;
				// cs.refresh = 680;
				cs.char2PosX = 480;
				cs.char2PosY = 305;
				cs.init2("VegetaRest2", ar);
			}

		}

	}

}
