package com.example.demo.init;

import com.example.demo.model.RealEstate;
import com.example.demo.model.RealEstateCategory;
import com.example.demo.model.RealEstateType;
import com.example.demo.service.RealEstateService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@AllArgsConstructor
@Slf4j
public class RealEstateInitializer implements CommandLineRunner {

    private final RealEstateService realEstateService;

    private static int houseCount = 1;
    private static int officeCount = 1;
    private static int villaCount = 1;
    private static int apartmentCount = 1;
    private static final int FURNITURE_COUNT = 10;
    private static final int CATEGORY_COUNT = 4;
    private static final Random rand = new Random();

    @Override
    public void run(String... args) throws Exception {
        List<RealEstate> realEstates = Arrays.asList(
                // HOME
                createRealEstate("House with a good view", "123 Street", "A house with a magnificent view is a perfect choice for those seeking tranquility and natural beauty. Imagine waking up to breathtaking vistas of rolling hills and lush greenery right outside your window. The panoramic scenery provides a sense of serenity and inspiration, making it an ideal retreat for nature lovers. Whether it's a sunrise or a sunset, each moment offers a picturesque tableau that can be admired from the comfort of your own home. This serene setting creates a peaceful ambiance, allowing you to unwind and recharge amidst the beauty of nature. With its stunning vistas, the house becomes a sanctuary where you can escape the hustle and bustle of daily life and truly connect with the surrounding environment. Whether you're enjoying a cup of coffee on the patio or hosting gatherings with loved ones, the mesmerizing view serves as a captivating backdrop, enhancing every experience. Indulge in the joy of watching birds soar through the sky, witnessing the changing colors of the seasons, and feeling the refreshing breeze brush against your skin. This house with a view embodies the perfect harmony between comfort and nature, offering an idyllic living space that truly feels like home.", RealEstateType.HOME, 6, 3, 20000000d, true),
                createRealEstate("Cozy Cottage", "456 Road", "Escape to a cozy cottage nestled in the heart of nature. This charming retreat offers a tranquil getaway from the hustle and bustle of city life. Surrounded by lush greenery and scenic landscapes, the cottage provides a serene ambiance where you can relax and rejuvenate. Step inside and feel the warmth of a rustic yet comfortable interior, with a fireplace to cozy up to on chilly evenings. The cottage features a well-equipped kitchen, inviting bedrooms, and a charming living area perfect for gatherings with family and friends. Enjoy the beauty of nature as you explore nearby hiking trails, take a leisurely stroll by the river, or simply unwind on the porch with a good book. This cozy cottage is a true haven of peace, offering a chance to disconnect from the outside world and reconnect with what truly matters.", RealEstateType.HOME, 3, 2, 10000000d, false),
                createRealEstate("Luxurious Mansion", "789 Avenue", "Experience the epitome of luxury living in this exquisite mansion. Every detail of this architectural masterpiece has been meticulously designed to provide the ultimate in comfort and elegance. From the grand entrance to the opulent living spaces, no expense has been spared in creating a residence that exudes sophistication and style. The mansion boasts a spacious layout with multiple bedrooms, each with its own en-suite bathroom. The gourmet kitchen is a chef's dream, featuring top-of-the-line appliances and ample counter space. The expansive outdoor area offers a resort-like atmosphere, complete with a swimming pool, beautifully landscaped gardens, and a covered patio for entertaining. With its state-of-the-art amenities and impeccable craftsmanship, this luxurious mansion sets a new standard for upscale living.", RealEstateType.HOME, 10, 8, 50000000d, true),
                createRealEstate("Beachfront Villa", "321 Beach Road", "Indulge in the ultimate beachfront living experience with this stunning villa. Located just steps away from the pristine sandy beach, this retreat offers breathtaking ocean views and direct access to the azure waters. The villa features a modern and open design, with floor-to-ceiling windows that bathe the interior in natural light and provide panoramic views of the coastline. The spacious bedrooms are havens of tranquility, offering a peaceful sanctuary to unwind and relax. The outdoor area is an oasis of serenity, with a private pool, sun loungers, and a shaded terrace where you can enjoy al fresco dining while listening to the sound of waves crashing against the shore. Whether you're sipping cocktails by the pool, taking long walks along the beach, or simply basking in the beauty of the sunset, this beachfront villa offers a lifestyle of luxury and leisure.", RealEstateType.HOME, 4, 4, 15000000d, true),
                createRealEstate("Mountain Retreat", "555 Summit Drive", "Escape to a mountain retreat and embrace the tranquility of nature. Nestled amidst majestic peaks and towering trees, this cozy retreat offers a peaceful getaway from the stresses of everyday life. The rustic charm of the cabin creates a warm and inviting atmosphere, with wood-paneled interiors and a crackling fireplace that adds a touch of coziness. Wake up to breathtaking views of the mountains and breathe in the crisp, fresh air as you enjoy your morning coffee on the deck. The surrounding trails beckon you to explore the natural beauty of the area, with hiking, biking, and skiing opportunities right at your doorstep. After a day of outdoor adventures, unwind in the hot tub or curl up with a good book by the fire. This mountain retreat is a haven for those seeking solace and serenity in nature's embrace.", RealEstateType.HOME, 2, 1, 8000000d, false),
                createRealEstate("Lake House", "777 Lake-view Lane", "Experience lakeside living at its finest with this stunning lake house. Situated on the shores of a pristine lake, this home offers panoramic views and direct access to the water. The spacious interior features an open floor plan, allowing for seamless flow between the living, dining, and kitchen areas. Large windows bathe the space in natural light and provide breathtaking views of the lake from every room. Step outside onto the deck and soak in the beauty of the surrounding landscape. The expansive outdoor area includes a private dock, perfect for boating, fishing, or simply enjoying the peaceful ambiance of the lake. Whether you're hosting gatherings with friends and family or enjoying quiet moments of relaxation, this lake house offers a lifestyle of serenity and natural beauty.", RealEstateType.HOME, 5, 3, 18000000d, true),
                createRealEstate("City Penthouse", "999 Skyline Avenue", "Elevate your urban living experience with this luxurious city penthouse. Located in the heart of the city, this exquisite residence offers breathtaking views of the skyline and the convenience of being close to all amenities. The penthouse features a modern and sophisticated design, with high-end finishes and state-of-the-art appliances. Floor-to-ceiling windows frame the panoramic views, creating a seamless connection between the interior and the cityscape. The spacious terrace is an oasis in the sky, providing a private outdoor retreat where you can unwind and entertain. Whether you're enjoying a cocktail at sunset or hosting a dinner party under the stars, this city penthouse offers a lifestyle of luxury and elegance.", RealEstateType.HOME, 3, 3, 30000000d, true),
                createRealEstate("Country Farmhouse", "222 Country Road", "Experience the charm of country living in this idyllic farmhouse. Surrounded by rolling fields and picturesque landscapes, this home offers a peaceful retreat away from the hustle and bustle of city life. The farmhouse features a blend of rustic and modern elements, with exposed beams, hardwood floors, and a cozy fireplace that creates a warm and inviting ambiance. The spacious kitchen is perfect for culinary enthusiasts, with ample counter space and a farmhouse sink. Step outside onto the wrap-around porch and enjoy the gentle breeze as you take in the scenic views. The expansive backyard offers endless possibilities, from gardening to hosting outdoor gatherings with family and friends. This country farmhouse is a true sanctuary, where you can reconnect with nature and create lasting memories.", RealEstateType.HOME, 4, 2, 12000000d, false),
                createRealEstate("Garden Oasis", "444 Bloom Street", "Step into a garden oasis and immerse yourself in the beauty of nature. This enchanting property boasts a meticulously landscaped garden filled with vibrant flowers, lush greenery, and peaceful water features. The outdoor space is designed to be a sanctuary of tranquility, with secluded seating areas where you can relax and enjoy the serenity of the surroundings. Inside the home, large windows bring the outdoors in, creating a seamless connection between the interior and the garden. The interior is equally stunning, with a bright and airy layout that maximizes natural light. The bedrooms are retreats of comfort and relaxation, offering a peaceful haven at the end of the day. Whether you're enjoying a leisurely stroll through the garden, hosting garden parties, or simply finding solace in the beauty of nature, this garden oasis is a true sanctuary for the soul.", RealEstateType.HOME, 3, 2, 9000000d, true),
                createRealEstate("Historic Manor", "666 Heritage Place", "Step back in time and experience the grandeur of a historic manor. This architectural masterpiece showcases the craftsmanship and elegance of a bygone era. From the moment you enter the stately entrance hall, you'll be transported to a world of refined luxury and timeless beauty. The manor features opulent living spaces, with high ceilings, intricate moldings, and ornate fireplaces that exude sophistication and charm. The grand staircase leads to a gallery of bedrooms, each with its own unique character and style. The sprawling grounds encompass manicured gardens, a sparkling pool, and a carriage house that adds to the estate's allure. Whether you're hosting formal gatherings in the grand ballroom or enjoying quiet moments of reflection in the library, this historic manor offers a living experience that is truly extraordinary.", RealEstateType.HOME, 8, 6, 40000000d, true),

                // OFFICE
                createRealEstate("Corporate Tower", "111 Business Avenue", "Welcome to the pinnacle of corporate excellence. This state-of-the-art corporate tower is a testament to modern architecture and functional design. With its sleek and contemporary exterior, the tower stands as an iconic symbol of success and prestige. Step inside and be greeted by a grand lobby that sets the tone for a professional and dynamic work environment. The tower offers flexible office spaces that can be customized to suit the unique needs of your business. From open-concept workspaces to private executive suites, every detail has been thoughtfully considered to promote productivity and collaboration. With advanced technology, top-notch amenities, and convenient access to major transportation hubs, this corporate tower is the perfect choice for businesses looking to make a statement and thrive in the heart of the city.", RealEstateType.OFFICE, 0, 0, 50000000d, false),
                createRealEstate("Co-working Space", "222 Innovation Street", "Embrace the future of work in this vibrant co-working space. Designed to foster creativity and collaboration, this dynamic environment brings together professionals from diverse industries, creating a community of innovation and entrepreneurship. The co-working space features modern and flexible workstations, meeting rooms, and communal areas that encourage networking and idea sharing. Whether you're a freelancer, a startup, or an established company, this space offers the flexibility and resources you need to thrive. With a range of amenities and a supportive community, you'll find inspiration and motivation to take your business to new heights. Join the co-working revolution and experience the power of collaboration.", RealEstateType.OFFICE, 0, 0, 20000000d, false),
                createRealEstate("Tech Hub", "333 Innovation Avenue", "Welcome to the epicenter of innovation and technology. This cutting-edge tech hub is designed to foster creativity, collaboration, and breakthrough discoveries. The space offers state-of-the-art facilities, including research labs, development studios, and prototype workshops, where visionary minds can bring their ideas to life. With its open and flexible layout, the tech hub encourages cross-disciplinary collaboration and knowledge sharing. From startups to established tech giants, this hub attracts the brightest minds and provides an ecosystem that nurtures innovation. Whether you're working on the latest advancements in artificial intelligence, blockchain technology, or biotech, this tech hub is the perfect environment to push the boundaries of what's possible.", RealEstateType.OFFICE, 0, 0, 30000000d, false),
                createRealEstate("Professional Suites", "444 Business Boulevard", "Elevate your professional image with these prestigious office suites. Designed for discerning professionals, these suites offer a blend of sophistication and functionality. The thoughtfully designed layout maximizes productivity and provides a comfortable and inspiring work environment. Each suite is equipped with modern amenities and high-speed internet connectivity, ensuring seamless operations and efficiency. The building offers ample parking, a welcoming reception area, and state-of-the-art conference rooms for client meetings and presentations. Whether you're a lawyer, consultant, or entrepreneur, these professional suites provide the ideal setting to meet with clients, collaborate with colleagues, and grow your business.", RealEstateType.OFFICE, 0, 0, 15000000d, false),
                createRealEstate("Executive Office", "555 Executive Drive", "Experience the pinnacle of luxury and exclusivity with these executive offices. Designed for top-level executives, these offices provide a prestigious and private workspace that reflects your status and success. The offices are meticulously designed with premium finishes, elegant furnishings, and state-of-the-art technology. Enjoy panoramic views of the cityscape as you work in a space that exudes sophistication and professionalism. The building offers a range of amenities, including a private lounge, dedicated parking, and concierge services, ensuring that every aspect of your workday is taken care of. Elevate your business to new heights with these executive offices that offer a combination of style, privacy, and functionality.", RealEstateType.OFFICE, 0, 0, 25000000d, false),

                // VILLA
                createRealEstate("Seaside Villa", "123 Ocean-view Road", "Experience the epitome of coastal living in this stunning seaside villa. Located in an exclusive waterfront community, this villa offers breathtaking views of the ocean and direct beach access. The spacious interior is bathed in natural light, creating a bright and inviting atmosphere. The open floor plan seamlessly connects the living, dining, and kitchen areas, making it perfect for entertaining. Step outside onto the expansive terrace and soak in the panoramic views while enjoying a dip in the infinity pool. The villa features luxurious amenities, including a home theater, a wine cellar, and a private gym. Whether you're lounging by the pool, hosting a dinner party, or taking a leisurely stroll along the beach, this seaside villa offers a lifestyle of luxury and relaxation.", RealEstateType.VILLA, 0, 0, 40000000d, false),
                createRealEstate("Tropical Retreat", "456 Paradise Lane", "Escape to your own private paradise with this exquisite tropical villa. Surrounded by lush palm trees and vibrant gardens, this retreat offers a secluded oasis where you can unwind and recharge. The villa features a contemporary design with open-concept living spaces that seamlessly blend indoor and outdoor living. The expansive windows provide breathtaking views of the tropical landscape, while the covered terrace offers a shaded retreat for al fresco dining and lounging. The bedrooms are spacious and elegantly appointed, ensuring a restful night's sleep. Step outside and discover a world of luxury amenities, including a sparkling pool, a spa, and a fully equipped outdoor kitchen. Whether you're sipping cocktails by the pool, practicing yoga in the garden, or simply enjoying the serenity of nature, this tropical retreat offers a lifestyle of tranquility and bliss.", RealEstateType.VILLA, 0, 0, 30000000d, false),
                createRealEstate("Hilltop Mansion", "789 Summit Avenue", "Indulge in the grandeur of this hilltop mansion that offers unparalleled luxury and breathtaking views. Perched atop a private hill, this mansion commands attention with its striking architecture and meticulous craftsmanship. The interior is a masterpiece of design, with high ceilings, exquisite finishes, and grandiose chandeliers that create an ambiance of opulence. The mansion boasts multiple living and entertaining spaces, including a formal dining room, a private home theater, and a wine cellar. The master suite is a sanctuary of comfort and sophistication, featuring a private balcony, a spa-like ensuite bathroom, and a spacious walk-in closet. The outdoor area is an entertainer's dream, with a pool, a pool house, and sprawling gardens that offer a sense of tranquility and serenity. Experience the epitome of luxury living in this hilltop mansion that is truly in a class of its own.", RealEstateType.VILLA, 0, 0, 50000000d, false),
                createRealEstate("Countryside Estate", "999 Country Lane", "Escape to the countryside and immerse yourself in the beauty of nature with this charming estate. Situated on sprawling acres of land, this property offers a serene retreat away from the hustle and bustle of city life. The estate features a meticulously landscaped garden, a private lake, and a variety of outdoor amenities, including a tennis court, a greenhouse, and a horse stable. The interior is equally impressive, with spacious living areas, cozy fireplaces, and luxurious bedrooms. The gourmet kitchen is a chef's delight, equipped with top-of-the-line appliances and a large center island. Whether you're exploring the expansive grounds, enjoying a picnic by the lake, or indulging in a game of tennis, this countryside estate provides a lifestyle of luxury, privacy, and tranquility.", RealEstateType.VILLA, 0, 0, 20000000d, false),

                // APARTMENT
                createRealEstate("Luxury Penthouse", "123 Skyline Tower", "Live the high life in this luxurious penthouse apartment that offers unparalleled views and unrivaled elegance. Perched atop a prestigious tower, this penthouse boasts floor-to-ceiling windows that frame panoramic views of the city skyline. The interior is a masterpiece of modern design, with sleek finishes, high-end appliances, and premium fixtures. The open-concept living area is perfect for entertaining, while the private bedrooms provide a serene retreat. Step outside onto the private terrace and enjoy the breathtaking vistas while lounging in the infinity pool. The building offers a range of amenities, including a fitness center, a spa, and 24-hour concierge services. Experience the ultimate in urban living with this luxury penthouse that redefines sophistication and style.", RealEstateType.APARTMENT, 0, 0, 35000000d, false),
                createRealEstate("City Center Apartment", "456 Central Street", "Immerse yourself in the vibrant energy of the city with this centrally located apartment. Situated in the heart of downtown, this apartment offers convenient access to shops, restaurants, and cultural attractions. The interior is thoughtfully designed with modern finishes and smart features that enhance comfort and functionality. The open-concept living area is ideal for entertaining, while the cozy bedrooms provide a peaceful haven. Step outside and discover a bustling neighborhood filled with cafes, boutiques, and art galleries. Whether you're exploring the city's vibrant nightlife, attending cultural events, or simply enjoying a leisurely stroll in the park, this city center apartment puts you at the center of it all.", RealEstateType.APARTMENT, 0, 0, 15000000d, false),
                createRealEstate("Waterfront Residence", "789 Harbor Road", "Experience waterfront living at its finest with this stunning residence. Located along the waterfront, this apartment offers panoramic views of the harbor and direct access to the marina. The interior is designed to maximize natural light and capture the essence of coastal living. The open-concept living area seamlessly blends indoor and outdoor spaces, with a spacious balcony that overlooks the water. The bedrooms are spacious and elegantly appointed, offering a peaceful retreat at the end of the day. The building offers a range of amenities, including a fitness center, a waterfront pool, and a private boat dock. Whether you're boating, fishing, or simply enjoying the breathtaking sunsets, this waterfront residence provides a lifestyle of luxury and tranquility.", RealEstateType.APARTMENT, 0, 0, 25000000d, false),
                createRealEstate("Urban Loft", "999 Loft Avenue", "Discover the charm of urban living with this stylish loft apartment. Located in a converted warehouse, this loft combines industrial elements with modern design to create a unique and inviting space. The open floor plan features exposed brick walls, high ceilings, and large windows that flood the space with natural light. The versatile layout allows for flexible living and working arrangements, making it perfect for artists, entrepreneurs, and creative professionals. The loft is situated in a vibrant neighborhood, with trendy cafes, art galleries, and boutiques just steps away. Embrace the energy of the city and experience the allure of urban loft living in this one-of-a-kind apartment.", RealEstateType.APARTMENT, 0, 0, 10000000d, false)
        );

        realEstateService.saveAll(realEstates);
    }

    private RealEstate createRealEstate(String title, String address, String description, RealEstateType realEstateType, int bed, int bath, double price, boolean hasWife) {
        return RealEstate.builder()
                .title(title)
                .address(address)
                .description(description)
                .type(realEstateType)
                .category(getCategory())
                .bed(bed)
                .bath(bath)
                .price(price)
                .wife(hasWife)
                .titlePicture(getTitlePicture(realEstateType))
                .pictures(getSecondaryPictures())
                .build();
    }

    private RealEstateCategory getCategory() {
        int number = getRandomNumber(1, CATEGORY_COUNT);
        switch (number) {
            case 1 -> {
                return RealEstateCategory.NEW;
            }
            case 2 -> {
                return RealEstateCategory.COMFORT;
            }
            case 3 -> {
                return RealEstateCategory.BEST;
            }
            case 4 -> {
                return RealEstateCategory.POPULAR;
            }
            default -> {
                System.out.println("RealEstateCategory is not found in initializer");
                return null;
            }
        }
    }

    private int getRandomNumber(int min, int max) {
        return rand.nextInt(max - min + 1) + min;
    }

    private Collection<String> getSecondaryPictures() {
        int count = getRandomNumber(1, FURNITURE_COUNT);
        boolean[] dp = new boolean[FURNITURE_COUNT + 1];
        List<String> result = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            int number = getRandomNumber(1, FURNITURE_COUNT);
            if (dp[number]) {
                i--;
                continue;
            }
            dp[number] = true;
            result.add("furniture" + number + ".jpg");
        }

        return result;
    }

    private String getTitlePicture(RealEstateType realEstateType) {
        switch (realEstateType) {
            case HOME -> {
                return "house" + houseCount++ + ".jpg";
            }
            case VILLA -> {
                return "villa" + villaCount++ + ".jpg";
            }
            case OFFICE -> {
                return "office" + officeCount++ + ".jpg";
            }
            case APARTMENT -> {
                return "apartment" + apartmentCount++ + ".jpg";
            }
            default -> {
                System.out.println("RealEstateType is not found in initializer");
                return "";
            }
        }
    }
}
