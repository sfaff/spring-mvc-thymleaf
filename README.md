import React, { useState } from "react";
import { Button } from "primereact/button";
import "primereact/resources/themes/lara-light-blue/theme.css";
import "primereact/resources/primereact.min.css";
import "primeicons/primeicons.css";
import "primeflex/primeflex.css";

import { Divider } from "primereact/divider";

export default function CustomMegaMenu() {
  const [activeMenu, setActiveMenu] = useState(null);
  const [mobileMenuOpen, setMobileMenuOpen] = useState(false);
  const [hoveredItem, setHoveredItem] = useState(null);

  const menuData = [
    {
      label: "Furniture",
      icon: "pi pi-box",
      items: [
        {
          category: "Living Room",
          items: [
            { label: "Accessories", icon: "pi pi-star" },
            { label: "Armchair", icon: "pi pi-star" },
            { label: "Coffee Table", icon: "pi pi-star" },
            { label: "Sofa", icon: "pi pi-star" },
          ],
        },
        {
          category: "Kitchen",
          items: [
            { label: "Bar Stool", icon: "pi pi-star" },
            { label: "Chair", icon: "pi pi-star" },
            { label: "Table", icon: "pi pi-star" },
            { label: "Cabinet", icon: "pi pi-star" },
          ],
        },
        {
          category: "Bedroom",
          items: [
            { label: "Bed", icon: "pi pi-star" },
            { label: "Dresser", icon: "pi pi-star" },
            { label: "Nightstand", icon: "pi pi-star" },
            { label: "Wardrobe", icon: "pi pi-star" },
          ],
        },
      ],
    },
    {
      label: "Electronics",
      icon: "pi pi-mobile",
      items: [
        {
          category: "Computer",
          items: [
            { label: "Monitor", icon: "pi pi-desktop" },
            { label: "Mouse", icon: "pi pi-desktop" },
            { label: "Keyboard", icon: "pi pi-desktop" },
            { label: "Laptop", icon: "pi pi-desktop" },
          ],
        },
        {
          category: "Mobile",
          items: [
            { label: "Phone", icon: "pi pi-mobile" },
            { label: "Tablet", icon: "pi pi-mobile" },
            { label: "Smartwatch", icon: "pi pi-mobile" },
          ],
        },
        {
          category: "Audio",
          items: [
            { label: "Headphones", icon: "pi pi-volume-up" },
            { label: "Speakers", icon: "pi pi-volume-up" },
            { label: "Microphone", icon: "pi pi-volume-up" },
          ],
        },
      ],
    },
    {
      label: "Clothing",
      icon: "pi pi-shopping-bag",
      items: [
        {
          category: "Men",
          items: [
            { label: "Shirts", icon: "pi pi-user" },
            { label: "Pants", icon: "pi pi-user" },
            { label: "Shoes", icon: "pi pi-user" },
            { label: "Accessories", icon: "pi pi-user" },
          ],
        },
        {
          category: "Women",
          items: [
            { label: "Dresses", icon: "pi pi-user" },
            { label: "Tops", icon: "pi pi-user" },
            { label: "Shoes", icon: "pi pi-user" },
            { label: "Bags", icon: "pi pi-user" },
          ],
        },
      ],
    },
    {
      label: "Sports",
      icon: "pi pi-flag",
      items: [
        {
          category: "",
          items: [],
        },
        {
          category: "Outdoor",
          items: [
            { label: "Camping", icon: "pi pi-sun" },
            { label: "Hiking", icon: "pi pi-sun" },
            { label: "Cycling", icon: "pi pi-sun" },
          ],
        },
        {
          category: "Indoor",
          items: [
            { label: "Gym Equipment", icon: "pi pi-heart" },
            { label: "Yoga", icon: "pi pi-heart" },
            { label: "Weights", icon: "pi pi-heart" },
          ],
        },
      ],
    },
  ];

  const toggleMobileMenu = (index) => {
    setActiveMenu(activeMenu === index ? null : index);
  };

  return (
    <div className="min-h-screen bg-gray-50">
      <style>
        {`
          .custom-megamenu {
            background: white;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
            position: fixed;
            top: 0;
            left: 0;
            right: 0;
            z-index: 1001;
          }
          
          .menu-item {
            position: relative;
            padding: .5rem 1.5rem;
            cursor: pointer;
            transition: all 0.3s;
            border-bottom: 3px solid transparent;
          }
          
          .menu-item:hover {
            background: #f8f9fa;
           border-bottom-color: #3B82F6;
          }
          
          .menu-item.active {
            background: #f8f9fa;
          }
          
          .megamenu-panel {
            position: absolute;
            top: 100%;
            left: 0;
            right: 0;
            background: white;
            box-shadow: 0 4px 6px rgba(0,0,0,0.1);
            opacity: 0;
            visibility: hidden;
            transform: translateY(-10px);
            transition: all 0.3s ease;
            z-index: 1000;
          }
          
          .megamenu-panel.show {
            opacity: 1;
            visibility: visible;
            transform: translateY(0);
            z-index: 1001;
          }
          
          .category-title {
            color: #1e293b;
            margin-bottom: 1rem;
            font-size: 1.1rem;
            padding-bottom: 0.5rem;
          }
          
          .menu-link {
            display: flex;
            align-items: center;
            padding: 0.75rem 1rem;
            color: #475569;
            text-decoration: none;
            border-radius: 6px;
            transition: all 0.2s;
            cursor: pointer;
          }
          
          .menu-link:hover {
            background: #f1f5f9;
            color: #3B82F6;
          }
          
          .menu-link i {
            margin-right: 0.5rem;
            font-size: 0.875rem;
          }

          .item-description {
            color: #64748b;
            font-size: 0.95rem;
            min-height: 24px;
          }

          .hamburger-btn {
            display: none;
          }

          .desktop-menu {
            display: flex;
          }

          .mobile-menu {
            display: none;
          }

          /* Mobile Styles */
          @media screen and (max-width: 768px) {
            .hamburger-btn {
              display: block !important;
            }

            .desktop-menu {
              display: none !important;
            }

            .mobile-menu {
              display: block;
              position: fixed;
              top: 60px;
              left: 0;
              right: 0;
              bottom: 0;
              background: white;
              z-index: 1000;
              overflow-y: auto;
              transform: translateX(-100%);
              transition: transform 0.3s ease;
            }

            .mobile-menu.open {
              transform: translateX(0);
            }

            .mobile-menu-item {
              border-bottom: 1px solid #e2e8f0;
            }

            .mobile-menu-header {
              padding: 1rem;
              background: white;
              cursor: pointer;
              display: flex;
              align-items: center;
              justify-content: space-between;
            }

            .mobile-menu-header:active {
              background: #f8f9fa;
            }

            .mobile-menu-content {
              max-height: 0;
              overflow: hidden;
              transition: max-height 0.3s ease;
              background: #f8f9fa;
            }

            .mobile-menu-content.open {
              max-height: 2000px;
            }

            .mobile-category {
              padding: 0.75rem 1rem;
              background: white;
              margin: 0.5rem 1rem;
              border-radius: 6px;
            }

            .mobile-category-title {
              font-weight: 600;
              color: #1e293b;
              margin-bottom: 0.5rem;
              font-size: 0.95rem;
            }

            .menu-item {
              padding: 0.75rem 1rem;
            }

            .menu-link {
              padding: 0.5rem 0.75rem;
              font-size: 0.9rem;
            }
          }

          /* Tablet Styles */
          @media screen and (min-width: 769px) and (max-width: 1024px) {
            .menu-item {
              padding: 0.75rem 1rem;
              font-size: 0.9rem;
            }
          }
        `}
      </style>

      <nav className="custom-megamenu">
        <div className="flex align-items-center justify-content-between px-4">
          {/* Desktop Menu */}
          <div
            className="desktop-menu"
            onMouseLeave={() => {
              setActiveMenu(null);
              setHoveredItem(null);
            }}
          >
            {menuData.map((menu, index) => (
              <div
                key={index}
                className={`menu-item ${activeMenu === index ? "active" : ""}`}
                onMouseEnter={() => setActiveMenu(index)}
              >
                <div className="flex align-items-center gap-2">
                  <i className={menu.icon}></i>
                  <span className="font-semibold">{menu.label}</span>
                  <i className="pi pi-angle-down text-sm"></i>
                </div>
              </div>
            ))}

            {menuData.map((menu, index) => (
              <div
                key={`panel-${index}`}
                className={`megamenu-panel ${
                  activeMenu === index ? "show" : ""
                }`}
                onMouseEnter={() => setActiveMenu(index)}
                onMouseLeave={() => {
                  setActiveMenu(null);
                  setHoveredItem(null);
                }}
              >
                <div className="p-5">
                  <div className="grid">
                    {menu.items.map((category, catIndex) => (
                      <div key={catIndex} className="col-12 md:col-6 lg:col-4">
                        <div className="category-title">
                          {category.category}
                        </div>
                        <div className="flex flex-column gap-1">
                          {category.items.map((item, itemIndex) => (
                            <div
                              key={itemIndex}
                              className="menu-link"
                              onMouseEnter={() => setHoveredItem(item.label)}
                              onMouseLeave={() => setHoveredItem(null)}
                              onClick={() =>
                                console.log("Clicked:", item.label)
                              }
                            >
                              <i className={item.icon}></i>
                              <span>{item.label}</span>
                            </div>
                          ))}
                        </div>
                      </div>
                    ))}
                  </div>
                  <Divider />
                  <div className="item-description">{hoveredItem || ""}</div>
                </div>
              </div>
            ))}
          </div>

          {/* Mobile Hamburger */}
          <Button
            icon={mobileMenuOpen ? "pi pi-times" : "pi pi-bars"}
            className="hamburger-btn"
            text
            onClick={() => setMobileMenuOpen(!mobileMenuOpen)}
          />
        </div>

        {/* Mobile Menu */}
        <div className={`mobile-menu ${mobileMenuOpen ? "open" : ""}`}>
          {menuData.map((menu, index) => (
            <div key={index} className="mobile-menu-item">
              <div
                className="mobile-menu-header"
                onClick={() => toggleMobileMenu(index)}
              >
                <div className="flex align-items-center gap-2">
                  <i className={menu.icon}></i>
                  <span className="font-semibold">{menu.label}</span>
                </div>
                <i
                  className={`pi ${
                    activeMenu === index ? "pi-angle-up" : "pi-angle-down"
                  }`}
                ></i>
              </div>
              <div
                className={`mobile-menu-content ${
                  activeMenu === index ? "open" : ""
                }`}
              >
                {menu.items.map((category, catIndex) => (
                  <div key={catIndex} className="mobile-category">
                    <div className="mobile-category-title">
                      {category.category}
                    </div>
                    {category.items.map((item, itemIndex) => (
                      <div
                        key={itemIndex}
                        className="menu-link"
                        onClick={() => {
                          console.log("Clicked:", item.label);
                          setMobileMenuOpen(false);
                        }}
                      >
                        <i className={item.icon}></i>
                        <span>{item.label}</span>
                      </div>
                    ))}
                  </div>
                ))}
              </div>
            </div>
          ))}
        </div>
      </nav>

      <div className="p-4" style={{ marginTop: "80px" }}>
        <div className="card p-4 text-center">
          <h2 className="text-2xl md:text-3xl font-bold mb-3">
            Responsive Custom Mega Menu
          </h2>
          <p className="text-gray-600 mb-4">
            Hover on desktop or tap on mobile to see the mega menu
          </p>
        </div>
      </div>
    </div>
  );
}
