package com.example.hexesholdem;

public class GlobalDataStore {
    public static Boolean player_first = true;
    public static int cards_in_hand;
    public static int player_deck_index = 0;
    public static int ai_deck_index = 0;
    public static int turn_count = 0;
    public static int[] ai_hand = new int[5];
    public static int[] player_hand = new int[5];
    public static Boolean hex_cast = false;
    public static Boolean win = false;
    public static Boolean selection_state = false;
    public static int selected_card = 0;

    public static int found_card = 99;

    public static int[] ai_river = new int[4];
    public static int[] player_river = new int[4];
    public static int[] ai_face_down = new int[12];
    public static int[] player_face_down = new int[12];

    public static int[] discard = new int[72];
    public static int discard_index = 0;

    public static int[] player_deck;
    public static int[] ai_deck;

    public static int search_index = 0;

    static int cardLookup(int card) {
        //Ordinarily I'd use metaprogramming here, but Java HATED that, so we're stuck with this
        //garbage code.
        int[] this_sucks = {R.drawable.s01, R.drawable.s02, R.drawable.s03, R.drawable.s04,
                R.drawable.s05, R.drawable.s06, R.drawable.s07, R.drawable.s08, R.drawable.s09,
                R.drawable.s10, R.drawable.s11, R.drawable.s12, R.drawable.s13, R.drawable.s14,
                R.drawable.p01, R.drawable.p02, R.drawable.p03, R.drawable.p04, R.drawable.p05,
                R.drawable.p06, R.drawable.p07, R.drawable.p08, R.drawable.p09, R.drawable.p10,
                R.drawable.p11, R.drawable.p12, R.drawable.p13, R.drawable.p14, R.drawable.c01,
                R.drawable.c02, R.drawable.c03, R.drawable.c04, R.drawable.c05, R.drawable.c06,
                R.drawable.c07, R.drawable.c08, R.drawable.c09, R.drawable.c10, R.drawable.c11,
                R.drawable.c12, R.drawable.c13, R.drawable.c14, R.drawable.w01, R.drawable.w02,
                R.drawable.w03, R.drawable.w04, R.drawable.w05, R.drawable.w06, R.drawable.w07,
                R.drawable.w08, R.drawable.w09, R.drawable.w10, R.drawable.w11, R.drawable.w12,
                R.drawable.w13, R.drawable.w14, R.drawable.m00, R.drawable.m01, R.drawable.m02,
                R.drawable.m03, R.drawable.m04, R.drawable.m05, R.drawable.m06, R.drawable.m07,
                R.drawable.m08, R.drawable.m09, R.drawable.m10, R.drawable.m11, R.drawable.m12,
                R.drawable.m13, R.drawable.m14, R.drawable.m15, R.drawable.m16, R.drawable.m17,
                R.drawable.m18, R.drawable.m19, R.drawable.m20, R.drawable.m21, R.drawable.empty};
        return this_sucks[card];
    }

    static Boolean needsTarget(int card) {
        Boolean need = false;
        int math_is_hard = card - 56;
        if ((math_is_hard > 0) && (((11 <= math_is_hard) && (math_is_hard <= 13)) || (math_is_hard == 15) || (math_is_hard == 20))) {
            need = true;
        }
        return need;
    }
}