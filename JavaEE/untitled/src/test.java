

// Please don't modify the class name.
public class Bowling {
    int zero = 0,ten=10,one=1;
    int score;
    int rolls[] = new int[21];
    int rollsIndex = 0;

    // Please don't modify the signature of this method.
    public void roll(int n) {
        this.rolls[rollsIndex] = n;
        this.rollsIndex++;
    }

    // Please don't modify the signature of this method.
    public int getScore() {
        if(this.score != zero) {
            this.score = zero;
        }

        boolean midFrame = false;
        boolean isStrike = false;

        for(int i = zero;i< this.rollsIndex;i++){

        }
        for(int i = zero; i < this.rollsIndex; i++) {
            if(this.rolls[i] == ten || midFrame) {
                if(isStrike) {
                    if(midFrame) {
                        this.score += this.rolls[i] + this.rolls[i - one];
                    } else {
                        if(i != this.rollsIndex - one) {
                            this.score += this.rolls[i] + this.rolls[i + one];
                        }
                    }
                    isStrike = false;
                }

                if(this.rolls[i] == ten && !midFrame) {
                    this.score += this.rolls[i];
                    isStrike = true;
                } else {
                    if((this.rolls[i-one] + this.rolls[i] == ten) && midFrame){
                        if(i != this.rollsIndex - one) {
                            this.score += this.rolls[i + one];
                        }
                    }
                    this.score += this.rolls[i] + this.rolls[i-one];
                    if (midFrame) {
                        midFrame = false;
                    }
                }
            } else {
                midFrame = true;
            }
        }
        return this.score;
    }
}
