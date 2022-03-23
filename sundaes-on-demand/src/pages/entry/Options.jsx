import axios from "axios";
import Row from "react-bootstrap/Row";
import { useEffect, useState } from "react";
import { ScoopOption } from "./ScoopOption";
import { ToppingOption } from "./ToppingOption";
import { AlertBanner } from "../common/AlertBanner";
import { pricePerItem } from "../../constants";
import { useOrderDetails } from "../../contexts/OrderDetails";

export const Options = ({ optionType }) => {
  const [items, setItems] = useState([]);
  const [error, setError] = useState(false);
  const [orderDetails, updateItemCount] = useOrderDetails();

  useEffect(() => {
    axios
      .get(`http://localhost:3030/${optionType}`)
      .then((response) => setItems(response.data))
      .catch((_) => setError(true));
    // setItems(
    //   optionType === "scoops"
    //     ? [
    //         {
    //           name: "Chocolate",
    //           imagePath: "/images/chocolate.png",
    //         },
    //         {
    //           name: "Vanilla",
    //           imagePath: "/images/vanilla.png",
    //         },
    //       ]
    //     : [
    //         {
    //           name: "Cherries",
    //           imagepath: "/images/cherries.png",
    //         },
    //         {
    //           name: "M&Ms",
    //           imagePath: "/images/m-and-ms.png",
    //         },
    //         {
    //           name: "Hot fudge",
    //           imagePath: "/images/hot-fudge.png",
    //         },
    //       ]
    // );
  }, [optionType]);

  if (error) {
    return <AlertBanner />;
  }

  const ItemComponent = optionType === "scoops" ? ScoopOption : ToppingOption;
  const title = optionType[0].toUpperCase() + optionType.slice(1).toLowerCase();

  const optionItems = items.map((item) => (
    <ItemComponent
      key={item.name}
      name={item.name}
      imagePath={item.imagePath}
      updateItemCount={(itemName, newItemCount) =>
        updateItemCount(itemName, newItemCount, optionType)
      }
    />
  ));

  return (
    <>
      <h2>{title}</h2>
      <p>{pricePerItem[optionType]} each</p>
      <p>
        {title} total: {orderDetails.totals[optionType]}
      </p>
      <Row>{optionItems}</Row>
    </>
  );
};
