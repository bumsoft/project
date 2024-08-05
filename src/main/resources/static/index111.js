let map;

async function initMap() {
    // console.log('list from html', store_list);
    //
    // store_list.forEach(ii=>{
    //     console.log(ii.name);
    //     console.log(ii.temp);
    //     console.log(ii.lat);
    //     console.log(ii.lng);
    // })

    /**
     *
     * @type {{lng: number, lat: number}}
     * 검색지역 기준으로 지도나오도록 할거니까 검색지역 좌표를 position으로.
     */
    const position = { lat: 37.299, lng: 126.837 };


    const cu_src = "https://www.pngfind.com/pngs/m/556-5565937_cu-logo-png-graphic-design-transparent-png.png";



    //@ts-ignore
    const { Map } = await google.maps.importLibrary("maps");
    const { AdvancedMarkerElement } = await google.maps.importLibrary("marker");

    map = new Map(document.getElementById("map"), {
        zoom: 15,
        center: position,
        mapId: "DEMO_MAP_ID",
    });


    //let markers = [];
    const infoWindow = new google.maps.InfoWindow();
    store_list.forEach((store) => {
        const cu_logo = document.createElement("img");
        cu_logo.src = cu_src;
        cu_logo.style.width = "50px";
        cu_logo.style.height = "50px";

        const marker = new AdvancedMarkerElement({
            map: map,
            position: {lat : store.lat, lng : store.lng},
            content: cu_logo,
            title: store.name,
            gmpClickable: true,
        });
        marker.temp = store.temp;

        marker.addListener("click", ({ domEvent, latLng }) => {
            const { target } = domEvent;

            infoWindow.close();

            const infoContent = `
             <div>
                <h3>${marker.title}</h3>
                <h4>${marker.temp}</h4>
                <p><a href="https://신청링크">신청</a></p>
            </div>
            ` ;
            infoWindow.setContent(infoContent);
            infoWindow.open(marker.map, marker);
        });
        //markers.push(marker);
    })
}

initMap();
