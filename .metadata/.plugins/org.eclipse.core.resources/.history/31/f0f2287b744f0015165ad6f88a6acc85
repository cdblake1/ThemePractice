package com.gampro;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import com.google.gson.JsonObject;

import main.java.riotapi.RiotApi;
import main.java.riotapi.RiotApiException;
import constant.Region;
import dto.Match.Event;
import dto.Match.Frame;
import dto.Match.MatchDetail;
import dto.Match.ParticipantIdentity;

public class Test {
	static Integer[] storedItemIds = { 1300, // berserker greaves enchantment:
												// furor
			1301, // berserker greaves enchantment: alacrity
			1302, // berserker greaves enchantment: captain
			1303, // berserker greaves enchantment: distortion
			1304, // berserker greaves enchantment: homeguards
			1305, // boots of swiftness enchantment: furor
			1306, // boots of swiftness enchantment: alacrity
			1307, // boots of swiftness enchantment: captain
			1308, // boots of swiftness enchantment: distortion
			1309, // boots of swiftness enchantment: homeguards
			1310, // sorcerer's shoes enchantment: furor
			1311, // sorcerer's shoes enchantment: alacrity
			1312, // sorcerer's shoes enchantment: captain
			1313, // sorcerer's shoes enchantment: distortion
			1314, // sorcerer's shoes enchantment: homeguards
			1315, // ninja tabi enchantment: furor
			1316, // ninja tabi enchantment: alacrity
			1317, // ninja tabi enchantment: captain
			1318, // ninja tabi enchantment: distortion
			1319, // ninja tabi enchantment: homeguards
			1320, // mercury treads enchantment: furor
			1321, // mercury treads enchantment: alacrity
			1322, // mercury treads enchantment: captain
			1323, // mercury treads enchantment: distortion
			1324, // mercury treads enchantment: homeguards
			1325, // boots of mobility enchantment: furor
			1326, // boots of mobility enchantment: alacrity
			1327, // boots of mobility enchantment: captain
			1328, // boots of mobility enchantment: distortion
			1329, // boots of mobility enchantment: homeguards
			1330, // ionian boots of lucidity enchantment: furor
			1331, // ionian boots of lucidity enchantment: alacrity
			1332, // ionian boots of lucidity enchantment: captain
			1333, // ionian boots of lucidity enchantment: distortion
			1334, // ionian boots of lucidity enchantment: homeguards
			2045, // ruby sightstone
			2049, // sightstone
			2053, // raptor cloak
			3001, // abyssal scepter
			3003, // archangel's staff
			3004, // manamune
			3006, // berserker's greaves
			3009, // boots of swiftness
			3020, // sorcerer's shoes
			3022, // frozen mallet
			3023, // twin shadows
			3025, // iceborn gauntlet
			3026, // guardian angel
			3027, // rod of ages
			3031, // infinity edge
			3035, // last whisper
			3041, // mejai's soulstealer
			3046, // phantom dancer
			3047, // ninja tabi
			3050, // zeke's harbinger
			3056, // ohmwrecker
			3060, // banner of command
			3065, // spirit visage
			3068, // sunfire cape
			3069, // talisman of ascension
			3071, // the black cleaver
			3072, // the bloodthirster
			3074, // ravenous hydra (melee only)
			3075, // thornmail
			3078, // trinity force
			3083, // warmog's armor
			3085, // runaan's hurricane (ranged only)
			3087, // statikk shiv
			3089, // rabadon's deathcap
			3091, // wit's end
			3092, // frost queen's claim
			3100, // lichbane
			3102, // banshee's veil
			3105, // aegis of the legion
			3110, // frozen heart
			3111, // mercury's treads
			3112, // orb of winter
			3115, // nashor's tooth
			3116, // rylai's crystal scepter
			3117, // boots of mobility
			3124, // guinsoo's rageblade
			3135, // void staff
			3139, // mercurial scimitar
			3141, // sword of the occult
			3142, // youmuu's ghostblade
			3143, // randuin's omen
			3146, // hextech gunblade
			3151, // liandry's torment
			3152, // will of the ancients
			3153, // blade of the ruined king
			3156, // maw of malmortious
			3157, // zhonya's hourglass
			3158, // ionian boots of lucidity
			3165, // morellonomicon
			3172, // zephyr
			3174, // athene's unholy grail
			3190, // locket of the solari
			3222, // mikael's crucible
			3285, // luden's echo
			3504, // ardent censer
			3508, // essence reaver
			3512, // zz'rot portal
			3707, // stalker's blade enchantment: warrior
			3708, // stalker's blade enchantment: runeglaive
			3709, // stalker's blade enchantment: cinderhulk
			3710, // stalker's blade enchantment: devourer
			3714, // skirmisher's sabre: warrior
			3716, // skirmisher's sabre: runeglaive
			3717, // skirmisher's sabre: cinderhulk
			3718, // skirmisher's sabre: devourer
			3719, // poacher's knife: warrior
			3720, // poacher's knife: runeglaive
			3721, // poacher's knife: cinderhulk
			3722, // poacher's knife: devourer
			3723, // ranger's trailblazer: warrior
			3724, // ranger's trailblazer: runeglaive
			3725, // ranger's trailblazer: cinderhulk
			3726, // ranger's trailblazer: devourer
			3800, // righteous glory
	};

	public static void main(String[] args) throws RiotApiException {
		Test.readWriteJson(Region.NA, "Win Win", 1913790383l, 2648l);
	}

	public static void readWriteJson(Region region, String title, Long matchId,
			Long sumId) throws RiotApiException {

		RiotApi api = new RiotApi("bf272907-42f9-4085-9470-1049579d9d2f");

		MatchDetail matchOne = api.getMatch(Region.NA, matchId, true);

		// collects frames from game
		ArrayList<Frame> frameList = new ArrayList<Frame>();
		frameList.addAll((Collection<? extends Frame>) matchOne.getTimeline()
				.getFrames());

		// stores summoner's id local to the match
		int sumPartId = 0;
		for (ParticipantIdentity participant : matchOne
				.getParticipantIdentities()) {
			if (participant.getPlayer().getSummonerId() == sumId) {
				sumPartId = participant.getParticipantId();
			}
		}
		// item purchase, counter++ add item id, item sold/destroyed/undo,
		// counter++ subtract item id
		// grabs starting items from frame 1 & 2

		ArrayList<BlockForItems> allEvents = new ArrayList<BlockForItems>();
		
		for (int i = 1; i < frameList.size(); i++) {
			ArrayList<Integer> items = new ArrayList<Integer>();
			BlockForItems block = new BlockForItems(items);
			for (int j = 0; j < frameList.get(i).getEvents().size(); j++) {
				Event event = frameList.get(i).getEvents().get(j);
				if (event.getParticipantId() == sumPartId) {
					if (event.getEventType().equals("ITEM_PURCHASED")) {
						items.add(event.getItemId());
						block.setItems(items);
					} else if (event.getEventType().equals("ITEM_UNDO")) {
						items.remove(items.lastIndexOf((Integer) event
								.getItemId()));
						block.setItems(items);
					}
				}
			}
			if(!(block.getItems().isEmpty())){
			allEvents.add(block);
			}
		}
		
		for(int i = 0; i < frameList.size(); i++){
			System.out.println("~" + frameList.get(i).getTimestamp()/60000 + ":00");
		}
				int counter = 0;
		System.out.println(allEvents.size());
		for (int i = 0; i < allEvents.size(); i++) {
			counter++;
			for (int j = 0; j < allEvents.get(i).getItems().size(); j++) {
				int blocks = allEvents.get(i).getItems().get(j);
				System.out.println(api.getDataItem(blocks).getName());
			}
			System.out.println(counter);
		}
		 for (BlockForItems itemId : allEvents) {
		 for (int i = 0; i < itemId.getItems().size(); i++) {
		 System.out.println(api.getDataItem(itemId.getItems().get(i))
		 .getName());
		 }
		 }
		 JsonObject jObject = GsonFileBuilder.gsonToJsonBuilder(allEvents);
		 try {
		 FileWriter file = new FileWriter(
		 "C:\\Riot Games\\League of Legends\\Config\\Champions\\Cassiopeia\\Recommended\\"
		 + "ItemSet_" + matchId + ".json");
		
		 file.write(jObject.toString());
		 file.flush();
		 file.close();
		
		 } catch (IOException e) {
		 e.printStackTrace();
		 }
		 System.out.println(jObject.toString());
	}
}
